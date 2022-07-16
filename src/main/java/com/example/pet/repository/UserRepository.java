package com.example.pet.repository;

import com.example.pet.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByLogin(String login);
}
