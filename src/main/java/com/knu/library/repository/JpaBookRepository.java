package com.knu.library.repository;

import com.knu.library.entity.BookEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class JpaBookRepository implements BookRepository {
    private final EntityManager em;

    public JpaBookRepository(EntityManager em) {
        this.em = em;
    }

    public void save(BookEntity book) {
        em.persist(book);
    }

    @Override
    public List<BookEntity> findAll() {
        List<BookEntity> result = em.createQuery("select b from book b", BookEntity.class)
                .getResultList();
        return result;
    }
}
