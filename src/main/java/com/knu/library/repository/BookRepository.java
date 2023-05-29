package com.knu.library.repository;

import com.knu.library.entity.BookEntity;

import java.util.List;

public interface BookRepository {
    void save(BookEntity bookEntity);

    List<BookEntity> findAll();
}
