package com.knu.library.repository;

import com.knu.library.domain.Member;
import com.knu.library.domain.UserBook;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    void save(Member member);

    Member findById(String id);

    List<UserBook> findUserBooks(String userid);

    void returnBook(Integer bookId);
}
