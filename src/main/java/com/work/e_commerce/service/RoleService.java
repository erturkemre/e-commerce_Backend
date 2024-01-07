package com.work.e_commerce.service;

import com.work.e_commerce.dto.RoleResponse;
import com.work.e_commerce.entity.Role;


import java.util.List;


public interface RoleService {
    List<RoleResponse> findAll();
    Role save(Role role);
    Role findById(long id);
    RoleResponse remove(long id);

}
