package com.example.javacms.service.impl;

import com.example.javacms.entity.Media;
import com.example.javacms.service.MediaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediaServiceImpl implements MediaService {

    @Override
    public List<Media> findAll() {
        return List.of();
    }

    @Override
    public Media findById(int id) {
        return null;
    }

    @Override
    public void save(Media media) {

    }

    @Override
    public void update(Media media) {

    }

    @Override
    public void deleteById(int id) {

    }
}
