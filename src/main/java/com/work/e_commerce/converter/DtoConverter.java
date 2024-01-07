package com.work.e_commerce.converter;

import com.work.e_commerce.dto.RoleResponse;
import com.work.e_commerce.dto.UserResponse;
import com.work.e_commerce.entity.Role;
import com.work.e_commerce.entity.User;


import java.util.ArrayList;
import java.util.List;

public class DtoConverter {

    public static List<UserResponse> convertToUserResponseList(List<User> users){
        List<UserResponse> responses = new ArrayList<>();
        users.forEach(user ->{
            responses.add(new UserResponse(user.getId(), user.getName(),user.getEmail(), user.getRoles()));
        });
        return responses;
    }

    public static UserResponse convertToResponse(User user){
        return new UserResponse(user.getId(), user.getName(),user.getEmail(), user.getRoles());
    }

    public static List<RoleResponse> convertToRoleResponseList(List<Role> roles){
        List<RoleResponse> responses = new ArrayList<>();
        roles.forEach(role ->{
            responses.add(new RoleResponse(role.getId(), role.getRoleName(),role.getStoreName(),role.getStorePhone(),role.getStoreTaxNum(),role.getIban()));
        });
        return responses;
    }
    public static RoleResponse convertToRoleResponse(Role role){
        return new RoleResponse(role.getId(), role.getRoleName(),role.getStoreName(),role.getStorePhone(),role.getStoreTaxNum(),role.getIban());
    }
}
