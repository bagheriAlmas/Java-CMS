package com.example.javacms.service;

import com.example.javacms.entity.Media;

import java.util.List;

public interface MediaService {
    List<Media> findAll();

    Media findById(int id);

    void save(Media media);

    void update(Media media);

    void deleteById(int id);
}
