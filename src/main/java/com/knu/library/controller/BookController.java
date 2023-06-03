package com.knu.library.controller;

import com.knu.library.domain.Book;
import com.knu.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/bookList")
    public String list(Model model) {
        List<Book.Simple> books = bookService.findBooks();
        model.addAttribute("books", books);
        return "book/bookList";
    }
}
