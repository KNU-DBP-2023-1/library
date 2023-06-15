package com.knu.library.repository;

import com.knu.library.entity.BookEntity;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    void save(BookEntity bookEntity);

    List<BookEntity> findAll();

    Optional<BookEntity> findById(Long id);

//    void rent(BookEntity bookEntity);

    void delete(BookEntity bookEntity);
}
