package com.careerinsta.insta_clone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.careerinsta.insta_clone.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUserName(String userName);	

}
