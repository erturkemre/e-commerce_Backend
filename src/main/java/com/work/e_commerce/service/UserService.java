package com.work.e_commerce.service;

import com.work.e_commerce.dto.UserResponse;
import com.work.e_commerce.dto.UserRoleResponse;
import com.work.e_commerce.entity.User;

import java.util.List;

public interface UserService {
    List<UserResponse> findAll();
    User save(User user);
    User findById(long id);
    UserResponse remove(long id);
    UserRoleResponse addRoleToUser(long userId, long roleId);


}
