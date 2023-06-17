package com.knu.library.service;

import com.knu.library.domain.Book;
import com.knu.library.domain.UserBook;
import com.knu.library.entity.BookEntity;
import com.knu.library.repository.BookRepository;
import com.knu.library.repository.MemberMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class BookService {

    private final BookRepository bookRepository;
    private final MemberMapper memberMapper;


    public BookService(BookRepository bookRepository, MemberMapper memberMapper) {
        this.bookRepository = bookRepository;
        this.memberMapper = memberMapper;
    }

    public List<Book.Simple> findBooks() {
        List<Book.Simple> list = new ArrayList<>();
        for (BookEntity bookEntity : bookRepository.findAll()) {
            Book.Simple book = new Book.Simple();
            book.setId(bookEntity.getId());
            book.setTitle(bookEntity.getTitle());
            book.setPublisher(bookEntity.getPublisher());
            book.setAuthor(bookEntity.getAuthor());
            book.setOnRent(bookEntity.getOnRent() ? "대출불가" : "대출가능");
            list.add(book);
        }
        return list;
    }
    public List<UserBook> findUserBooks(String userid) {
        return memberMapper.findUserBooks(userid);
    }

    public BookEntity getBookById(Long bookId) {
        return bookRepository.findById(bookId).orElseThrow(
                IllegalArgumentException::new
        );
    }

    /* 다시 작업 예정
    public void rentBook(Long bookId) {
        Book.Update book = new Book.Update();
        book.setOnRent(true);
        bookRepository.rent(bookId);
    }
     */

    public void updateBook(Long bookId, Book.Update updateForm) {
        BookEntity bookEntity = bookRepository.findById(bookId).orElseThrow(
                IllegalArgumentException::new
        );

        bookEntity.setTitle(updateForm.getTitle());
        bookEntity.setAuthor(updateForm.getAuthor());
        bookEntity.setPublisher(updateForm.getPublisher());
        bookRepository.save(bookEntity);
    }

    public void returnBook(Integer bookId) {
        memberMapper.returnBook(bookId);
    }

    public List<UserBook> findCondBooks(Book.Create bookForm) {
        UserBook bookEntity = new UserBook();
        bookEntity.setTitle(bookForm.getTitle());


        List<UserBook> list = new ArrayList<>();
        for(UserBook bookEntity2 : memberMapper.findCondName(bookEntity)) {
            UserBook book2 = new UserBook();
            book2.setId(bookEntity2.getId());
            book2.setTitle(bookEntity2.getTitle());
            book2.setPublisher(bookEntity2.getPublisher());
            book2.setAuthor(bookEntity2.getAuthor());
            book2.setOnRent(bookEntity2.getOnRent());
            list.add(book2);
        }
        return list;
    }


    public List<UserBook> findCondBooksId(Book.Simple bookForm) {
        UserBook bookEntity = new UserBook();
        bookEntity.setId(bookForm.getId());

        List<UserBook> list = new ArrayList<>();
        for(UserBook bookEntity2 : memberMapper.findCondId(bookEntity)) {
            UserBook book2 = new UserBook();
            book2.setId(bookEntity2.getId());
            book2.setTitle(bookEntity2.getTitle());
            book2.setPublisher(bookEntity2.getPublisher());
            book2.setAuthor(bookEntity2.getAuthor());
            book2.setOnRent(bookEntity2.getOnRent());
            list.add(book2);
        }
        return list;
    }
}