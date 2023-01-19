package com.tweeteroo.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweeteroo.api.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
