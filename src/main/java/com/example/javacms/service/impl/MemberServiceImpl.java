package com.example.javacms.service.impl;

import com.example.javacms.entity.Member;
import com.example.javacms.service.MemberService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Override
    public List<Member> findAll() {
        return List.of();
    }

    @Override
    public Member findById(long id) {
        return null;
    }

    @Override
    public void save(Member member) {

    }

    @Override
    public void update(Member member) {

    }

    @Override
    public void deleteById(long id) {

    }
}
