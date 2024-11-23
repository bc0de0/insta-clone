package com.careerinsta.insta_clone.service;

import com.careerinsta.insta_clone.dto.UserDTO;
import com.careerinsta.insta_clone.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    UserDTO getUserById(String id);

    User updateUserById(String id, UserDTO user);

    UserDTO deleteUserById(String id);

    User updateUserByUserName(String userName, UserDTO userDTO);

}
