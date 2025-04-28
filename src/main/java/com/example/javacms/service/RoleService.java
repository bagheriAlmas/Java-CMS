package com.example.javacms.service;

import com.example.javacms.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();

    Role findById(int id);

    void save(Role role);

    void update(Role role);

    void deleteById(int id);
}
