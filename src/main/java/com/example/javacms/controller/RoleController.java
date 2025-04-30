package com.example.javacms.controller;

import com.example.javacms.entity.dto.RoleRequestDto;
import com.example.javacms.entity.dto.RoleResponseDto;
import com.example.javacms.service.RoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/role")
@RequiredArgsConstructor
public class RoleController{

    private final RoleService roleService;

    @GetMapping
    ResponseEntity<List<RoleResponseDto>> getAllRoles() {
        return ResponseEntity.status(HttpStatus.OK).body(roleService.findAll());
    }

    @GetMapping("{id}")
    ResponseEntity<RoleResponseDto> getRoleById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(roleService.findById(id));
    }

    @PostMapping
    ResponseEntity<Void> insertRole(@RequestBody @Valid RoleRequestDto requestDto) {
        roleService.save(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("{id}")
    ResponseEntity<Void> updateRole(@PathVariable("id") Long id, @RequestBody @Valid RoleRequestDto requestDto) {
        roleService.update(id, requestDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("{id}")
    ResponseEntity<Void> deleteRole(@PathVariable("id") Long id) {
        roleService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
