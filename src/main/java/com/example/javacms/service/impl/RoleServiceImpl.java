package com.example.javacms.service.impl;

import com.example.javacms.entity.Role;
import com.example.javacms.common.exceptions.RoleNotFoundException;
import com.example.javacms.entity.dto.RoleRequestDto;
import com.example.javacms.entity.dto.RoleResponseDto;
import com.example.javacms.repository.RoleRepository;
import com.example.javacms.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public List<RoleResponseDto> findAll() {
        final var roleList = roleRepository.findAll();
        return roleList.stream().map(Role::toDto).toList();
    }

    @Override
    public RoleResponseDto findById(long id) {
        final var role = roleRepository.findById(id).orElseThrow(RoleNotFoundException::new);
        return Role.toDto(role);
    }

    @Override
    public void save(RoleRequestDto requestDto) {
        final var role = Role.fromDto(requestDto);
        roleRepository.save(role);
    }

    @Override
    public void update(long id, RoleRequestDto requestDto) {
        final var dbRole = roleRepository.findById(id).orElseThrow(RoleNotFoundException::new);
        dbRole.setRoleName(requestDto.roleName());
        roleRepository.save(dbRole);
    }

    @Override
    public void deleteById(long id) {
        roleRepository.deleteById(id);
    }
}
