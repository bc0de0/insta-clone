package com.careerinsta.insta_clone.controller;

import com.careerinsta.insta_clone.dto.UserDTO;
import com.careerinsta.insta_clone.entity.User;
import com.careerinsta.insta_clone.service.UserServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {


    private final UserServiceImp userServiceImp;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> allUsers = userServiceImp.getAllUsers();
        return new ResponseEntity<List<User>>(allUsers, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable String id) {
        UserDTO userById = userServiceImp.getUserById(id);
        return new ResponseEntity<UserDTO>(userById, HttpStatus.OK);
    }

    @PutMapping("/update/{userName}")
    public ResponseEntity<User> updateUserById(@PathVariable String userName, @RequestBody UserDTO userDTO) {
        User user = userServiceImp.updateUserByUserName(userName, userDTO);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable String id) {
        UserDTO userDTO = userServiceImp.deleteUserById(id);
        return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
    }
}
