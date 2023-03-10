package com.tweeteroo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweeteroo.api.models.User;
import com.tweeteroo.api.repositories.UserRepository;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired
  private UserRepository repository;

  @PostMapping("/sign-up")
  public ResponseEntity<String> signUp(@RequestBody User userData) {
    try {
      List<User> user = repository.findByUsername(userData.getUsername());

      if (user.size() > 0) {
        return ResponseEntity.status(409).body("this username is already in use");
      }

      repository.save(userData);
    } catch (Exception e) {
      if (e instanceof DataIntegrityViolationException) {
        return ResponseEntity.status(400).body(e.getMessage());
      }

      return ResponseEntity.status(500).body(e.getMessage());
    }

    return ResponseEntity.status(201).body("OK");
  }
}
