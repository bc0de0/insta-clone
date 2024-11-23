package com.careerinsta.insta_clone.service;

import com.careerinsta.insta_clone.dto.UserDTO;
import com.careerinsta.insta_clone.entity.User;
import com.careerinsta.insta_clone.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        List<User> all = userRepository.findAll();
        return all;
    }

    @Override
    public UserDTO getUserById(String id) {
        User byId = userRepository.findById(id);

        return UserDTO
                .builder()
                .username(byId.getEmail())
                .name(byId.getUserName())
                .bio(byId.getBio())
                .bioImage(byId.getProfileImagePath())
                .email(byId.getEmail())
                .id(id)
                .build();
    }

    @Override
    public User updateUserById(String id, UserDTO user) {
        User byId = userRepository.findById(id);

        return User
               .builder()
               .email(user.getEmail())
               .profileImagePath(user.getBioImage())
               .bio(user.getBio())
               .userName(user.getName())
               .build();

    }

    @Override
    public UserDTO deleteUserById(String id) {
        UserDTO userById = getUserById(id);
        userRepository.deleteAllById(id);
        return userById;
    }

    @Override
    public User updateUserByUserName(String userName, UserDTO userDTO) {
        User byUserName = userRepository.findByUserName(userName);
        String id = String.valueOf(byUserName.getId());

        return updateUserById(id, userDTO);
    }
}
