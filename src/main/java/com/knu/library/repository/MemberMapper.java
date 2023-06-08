package com.knu.library.repository;

import com.knu.library.domain.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    void save(Member member);

    Member findById(String id);
}