package com.knu.library.service;

import com.knu.library.domain.Book;
import com.knu.library.entity.BookEntity;
import com.knu.library.repository.BookRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book.Simple> findBooks() {
        List<Book.Simple> list = new ArrayList<>();
        for (BookEntity bookEntity : bookRepository.findAll()) {
            Book.Simple book = new Book.Simple();
            book.setId(bookEntity.getId());
            book.setTitle(bookEntity.getTitle());
            book.setPublisher(bookEntity.getPublisher());
            book.setAuthor(bookEntity.getAuthor());
            book.setOnRent(book.getOnRent());
            list.add(book);
        }
        return list;
    }
}
