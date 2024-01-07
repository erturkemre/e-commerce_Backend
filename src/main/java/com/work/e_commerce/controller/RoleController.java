package com.work.e_commerce.controller;

import com.work.e_commerce.dto.RoleResponse;
import com.work.e_commerce.entity.Role;
import com.work.e_commerce.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")

public class RoleController {
    RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/")
    public Role save(@RequestBody Role role){
        return roleService.save(role);
    }

    @GetMapping("/")
    public List<RoleResponse> findAll()
    {
        return roleService.findAll();

    }
    @GetMapping("/{id}")
    public RoleResponse findById(@PathVariable long id){
        Role role = roleService.findById(id);
        return new RoleResponse(role.getId(), role.getRoleName(),role.getStoreName(),role.getStorePhone(),role.getStoreTaxNum(),role.getIban());
    }

}
