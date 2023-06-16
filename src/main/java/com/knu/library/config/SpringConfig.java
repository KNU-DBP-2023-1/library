package com.knu.library.config;

import com.knu.library.repository.BookRepository;
import com.knu.library.repository.JpaBookRepository;
import com.knu.library.repository.MemberMapper;
import com.knu.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public BookRepository bookRepository() {
        return new JpaBookRepository(em);
    }
}
