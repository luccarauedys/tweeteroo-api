package com.tweeteroo.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweeteroo.api.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
  List<User> findByUsername(String username);
}
