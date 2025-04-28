package com.example.javacms.service;

import com.example.javacms.entity.Media;
import com.example.javacms.entity.User;

import java.util.List;

public interface MediaService {
    List<Media> findAll();

    Media findById(int id);

    void save(User user);

    void update(User user);

    void deleteById(int id);
}
