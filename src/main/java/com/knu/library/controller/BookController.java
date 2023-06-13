package com.knu.library.controller;

import com.knu.library.domain.Book;
import com.knu.library.domain.Member;
import com.knu.library.domain.UserBook;
import com.knu.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/bookList")
    public String list(Model model, HttpServletRequest request) {
        // === 로그인 처리 로직 시작 ===
        Member loginMember = getLoginMember(request);
        if (loginMember == null) return "redirect:/";
        model.addAttribute("member", loginMember);
        // === 로그인 처리 로직 끝 ===

        List<Book.Simple> books = bookService.findBooks();
        model.addAttribute("books", books);
        return "book/bookList";
    }

    @GetMapping(value= "/myPage")
    public String userBookList(Model model, HttpServletRequest request){
        // === 로그인 처리 로직 시작 ===
        Member loginMember = getLoginMember(request);
        if (loginMember == null) return "redirect:/";
        model.addAttribute("member", loginMember);
        // === 로그인 처리 로직 끝 ===

        List<UserBook> books = bookService.findUserBooks(loginMember.getId());
        model.addAttribute("books", books);
        return "myPage";
    }

    @GetMapping("/return")
    public String returnBook(@RequestParam Integer id) {
        bookService.returnBook(id);
        return "redirect:/myPage";
    }

    private Member getLoginMember(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) { //세션 쿠키가 존재하지 않으면
            System.out.println("[BookController] session is null");
            return null;
        }

        Member loginMember = (Member)session.getAttribute("loginMember");

        if (loginMember == null) { //세션에 회원 데이터가 없으면
            System.out.println("[BookController] loginMember is null");
            return null;
        }
        return loginMember;
    }

    // 아직 미완성
//    @GetMapping(value = "/bookList/{bookId}/rent")
//    public String getBookRentForm(@PathVariable Long bookId, Model model) {
//        BookEntity bookEntity = bookService.getBookById(bookId);
//        model.addAttribute("book", bookEntity);
//        return "book/bookRentForm";
//    }
//
//    @PostMapping("/bookList/{bookId}/rent")
//    public String getBookRent(@PathVariable Long bookId, Model model) {
//        model.addAttribute("id", bookId);
//        bookService.rentBook(bookId);
//        return "redirect:/bookList";
//    }
}
