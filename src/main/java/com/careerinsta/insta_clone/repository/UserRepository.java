package com.careerinsta.insta_clone.repository;

import com.careerinsta.insta_clone.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import com.careerinsta.insta_clone.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUserName(String userName);

	User findById(String id);

	void deleteAllById(String id);
}
