package com.example.javacms.service;

import com.example.javacms.entity.Role;
import com.example.javacms.entity.User;

import java.util.List;

public interface RoleService {
    List<Role> findAll();

    Role findById(int id);

    void save(User user);

    void update(User user);

    void deleteById(int id);
}
