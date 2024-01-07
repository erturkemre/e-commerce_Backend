package com.work.e_commerce.dto;

import com.work.e_commerce.entity.Role;

import java.util.List;

public record UserResponse(long id, String name, String email, List<Role> role) {
}
