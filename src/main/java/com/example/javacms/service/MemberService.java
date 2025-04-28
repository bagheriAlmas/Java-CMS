package com.example.javacms.service;

import com.example.javacms.entity.Member;

import java.util.List;

public interface MemberService {
    List<Member> findAll();

    Member findById(long id);

    void save(Member member);

    void update(Member member);

    void deleteById(long id);
}
