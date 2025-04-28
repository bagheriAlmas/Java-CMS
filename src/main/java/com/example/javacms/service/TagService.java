package com.example.javacms.service;

import com.example.javacms.entity.Tag;

import java.util.List;

public interface TagService {
    List<Tag> findAll();

    Tag findById(int id);

    void save(Tag tag);

    void update(Tag tag);

    void deleteById(int id);
}
