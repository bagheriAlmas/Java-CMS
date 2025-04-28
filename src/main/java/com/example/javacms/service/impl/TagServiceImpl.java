package com.example.javacms.service.impl;

import com.example.javacms.entity.Tag;
import com.example.javacms.entity.User;
import com.example.javacms.service.TagService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Override
    public List<Tag> findAll() {
        return List.of();
    }

    @Override
    public Tag findById(int id) {
        return null;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void deleteById(int id) {

    }
}
