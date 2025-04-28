package com.example.javacms.service.impl;

import com.example.javacms.entity.Media;
import com.example.javacms.entity.User;
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
    public void save(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void deleteById(int id) {

    }
}
