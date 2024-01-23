package com.work.e_commerce.controller;

import com.work.e_commerce.dto.UserResponse;
import com.work.e_commerce.entity.User;
import com.work.e_commerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public ResponseEntity<User> save(@RequestBody User user){
        User savedUser = userService.save(user);
        return ResponseEntity.ok(savedUser);
    }
    @GetMapping("/")
    public ResponseEntity<List<UserResponse>> findAll(){
        List<UserResponse> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public UserResponse findById(@PathVariable long id){
        User findedUser = userService.findById(id);
        return new UserResponse(findedUser.getId(),findedUser.getName(),findedUser.getEmail(),findedUser.getRoles());
    }
    @DeleteMapping("/{id}")
    public UserResponse remove(@PathVariable long id){
        return userService.remove(id);
    }

}
