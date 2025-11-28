package com.htn.controller;

import com.htn.dto.UserDTO;
import com.htn.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/users")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Long userId){
        return response(userService.getUserById(userId));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable("email") String email){
        return response(userService.getUserByEmail(email));
    }

    @GetMapping("/exists-email/{email}")
    public ResponseEntity<?> existsEmail(@PathVariable("email") String email){
        return response(userService.existsEmail(email));
    }

    @PostMapping
    @PreAuthorize(value = "hasRole('ADMIN')")
    public ResponseEntity<?> addUser(@RequestBody UserDTO userDTO){
        return response(userService.addUser(userDTO));
    }

    @PutMapping(value ="/{id}")
    @PreAuthorize(value = "hasRole('ADMIN')")
    public ResponseEntity<?> updateUser(@PathVariable("id") Long id, @Valid @RequestBody UserDTO userDTO){
        return response(userService.updateUser(id, userDTO));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize(value = "hasRole('ADMIN')")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long userId){
        return response(userService.deleteUser(userId));
    }
}
