package com.knu.library.entity;

import com.knu.library.domain.Member;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String publisher;

    @Column
    private String author;

    @Column
    private Boolean onRent;
}
