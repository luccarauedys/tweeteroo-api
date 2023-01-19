package com.tweeteroo.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
      repository.save(userData);
    } catch (Exception e) {
      return ResponseEntity.status(400).body(e.getMessage());
    }

    return ResponseEntity.status(201).body("OK");
  }
}
