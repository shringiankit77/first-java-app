package com.assignment.rest;


import com.assignment.entity.UserEntity;
import com.assignment.model.User;
import com.assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class ApiController {

    @Autowired
    private UserService userService;

    // Create
    @PostMapping
    public UserEntity createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // Get by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUser(@PathVariable Long id) {
        Optional<UserEntity> user =userService.findUserById(id);
        return user
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable Long id, @RequestBody User updatedUserEntity) {

        Optional<UserEntity> user =userService.updateUser(id, updatedUserEntity);
        return user
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
