package com.work.e_commerce.service;

import com.work.e_commerce.converter.DtoConverter;
import com.work.e_commerce.dto.RoleResponse;
import com.work.e_commerce.dto.UserResponse;
import com.work.e_commerce.dto.UserRoleResponse;
import com.work.e_commerce.entity.Role;
import com.work.e_commerce.entity.User;
import com.work.e_commerce.exception.ErrorException;
import com.work.e_commerce.exception.GlobalErrorHandler;
import com.work.e_commerce.repository.RoleRepository;
import com.work.e_commerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.context.LifecycleAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    UserRepository userRepository;
    RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<UserResponse> findAll() {
        return DtoConverter.convertToUserResponseList(userRepository.findAll());
    }

    @Override
    public User save(User user) {
        return  userRepository.save(user);
    }

    @Override
    public User findById(long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            return userOptional.get();
        }
        throw new ErrorException("User not found", HttpStatus.NOT_FOUND);
    }

    @Override
    public UserResponse remove(long id) {
        User willRemove = findById(id);
        userRepository.delete(willRemove);
        return DtoConverter.convertToResponse(willRemove);
    }

    @Override
    public UserRoleResponse addRoleToUser(long userId, long roleId) {
        User user = userRepository.findById(userId).get();
        Role role = roleRepository.findById(roleId).get();
        if(user.getRoles().contains(role))
        {
            throw new RuntimeException("Role with given id already defined" + roleId);
        }
        user.addRole(role);
        User savedUser = userRepository.save(user);

        List<RoleResponse> roleResponses = new ArrayList<>();
        for(Role role1:savedUser.getRoles()){
            roleResponses.add(new RoleResponse(role1.getId(),role1.getRoleName(),role1.getStoreName(),role1.getStorePhone(),role1.getStoreTaxNum(),role1.getIban()));
        }


        return new UserRoleResponse(user.getId(),user.getName(), user.getEmail(), roleResponses);
    }
}
