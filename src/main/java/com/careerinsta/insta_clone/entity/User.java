package com.careerinsta.insta_clone.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 3)
    @Column(nullable = false, unique = true)
    private String userName;
    
    @NotNull
    @Column(nullable = false, unique = true)
    private String email;

    @NotNull
    @Column(nullable = false)
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Size(max = 500)
    private String bio;

    private String profileImagePath;

    // Constructors, getters, setters

    public User() {
    }

    public User(Long id, String userName, String email, String passwordHash, Gender gender, String bio,
                String profileImagePath) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.passwordHash = passwordHash;
        this.gender = gender;
        this.bio = bio;
        this.profileImagePath = profileImagePath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getProfileImagePath() {
        return profileImagePath;
    }

    public void setProfileImagePath(String profileImagePath) {
        this.profileImagePath = profileImagePath;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", userName=" + userName + ", email=" + email + ", gender=" + gender + ", bio=" + bio
                + ", profileImagePath=" + profileImagePath + "]";
    }
}
