package com.knu.library.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter @Setter
@Entity(name = "member")
public class MemberEntity {
    @Id
    private String id;

    @Column
    private String pw;

    @Column
    private String name;
}