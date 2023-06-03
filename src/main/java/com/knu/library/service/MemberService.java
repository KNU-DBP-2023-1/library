package com.knu.library.service;

import com.knu.library.domain.Member;
import com.knu.library.repository.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Slf4j
@Service
public class MemberService {
    private final MemberMapper memberMapper;

    @Transactional
    public void save(Member member) {
        log.info("member={}", member);
        memberMapper.save(member);
    }

    public Member login(String id, String pw) {
        Member member = memberMapper.findById(id);
        if (member.getPw().equals(pw)) {
            return member;
        } else {
            return null;
        }
    }
}
