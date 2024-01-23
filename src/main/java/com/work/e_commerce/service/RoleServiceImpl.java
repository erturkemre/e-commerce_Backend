package com.work.e_commerce.service;

import com.work.e_commerce.converter.DtoConverter;
import com.work.e_commerce.dto.RoleResponse;
import com.work.e_commerce.entity.Role;
import com.work.e_commerce.exception.ErrorException;
import com.work.e_commerce.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService{

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<RoleResponse> findAll() {
        return DtoConverter.convertToRoleResponseList(roleRepository.findAll());
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role findById(long id) {
        Optional<Role> roleOptional = roleRepository.findById(id);
        if(roleOptional.isPresent()){
            return roleOptional.get();
        }
        throw new ErrorException("Role is not found", HttpStatus.NOT_FOUND);
    }

    @Override
    public RoleResponse remove(long id) {
        Role willRemove = findById(id);
        roleRepository.delete(willRemove);
        return DtoConverter.convertToRoleResponse(willRemove);
    }
}
