package com.example.javacms.service;

import com.example.javacms.entity.dto.RoleRequestDto;
import com.example.javacms.entity.dto.RoleResponseDto;

import java.util.List;

public interface RoleService {
    List<RoleResponseDto> findAll();

    RoleResponseDto findById(long id);

    void save(RoleRequestDto requestDto);

    void update(long id, RoleRequestDto requestDto);

    void deleteById(long id);
}
