package com.example.javacms.service.impl;

import com.example.javacms.entity.Role;
import com.example.javacms.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Override
    public List<Role> findAll() {
        return List.of();
    }

    @Override
    public Role findById(long id) {
        return null;
    }

    @Override
    public void save(Role role) {

    }

    @Override
    public void update(Role role) {

    }

    @Override
    public void deleteById(long id) {

    }
}
