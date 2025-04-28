package com.example.javacms.controller;

import com.example.javacms.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/role")
@RequiredArgsConstructor
public class RoleController{
    private final RoleService roleService;
}
