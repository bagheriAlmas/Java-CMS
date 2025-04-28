package com.example.javacms.service;

import com.example.javacms.entity.Tag;

import java.util.List;

public interface TagService {
    List<Tag> findAll();

    Tag findById(long id);

    void save(Tag tag);

    void update(Tag tag);

    void deleteById(long id);
}
