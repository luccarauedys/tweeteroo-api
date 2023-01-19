package com.tweeteroo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweeteroo.api.models.Tweet;
import com.tweeteroo.api.models.User;
import com.tweeteroo.api.repositories.TweetRepository;
import com.tweeteroo.api.repositories.UserRepository;

@RestController
@RequestMapping("/api/tweets")
public class TweetController {
  @Autowired
  private TweetRepository tweetRepository;

  @Autowired
  private UserRepository userRepository;

  @PostMapping
  public ResponseEntity<String> create(@RequestBody Tweet tweetData) {
    try {
      List<User> user = userRepository.findByUsername(tweetData.getUsername());
      if (user.size() == 0) {
        return ResponseEntity.status(404).body("unable to post tweet, user not found");
      }

      String avatar = user.get(0).getAvatar();
      tweetData.setAvatar(avatar);
      tweetRepository.save(tweetData);
    } catch (Exception e) {
      if (e instanceof DataIntegrityViolationException) {
        return ResponseEntity.status(400).body(e.getMessage());
      }
      return ResponseEntity.status(500).body(e.getMessage());
    }

    return ResponseEntity.status(201).body("OK");
  }

  @GetMapping
  public List<Tweet> getWithPagination(@RequestParam(defaultValue = "0") int page) {
    int initialPage = page;
    int pageSize = 5;

    Pageable lastFiveTweets = PageRequest.of(initialPage, pageSize).withSort(Direction.DESC, "id");
    Page<Tweet> pagedResult = tweetRepository.findAll(lastFiveTweets);

    return pagedResult.toList();
  }

  @GetMapping("/{username}")
  public List<Tweet> getByUsername(@PathVariable String username) {
    return tweetRepository.findByUsername(username);
  }
}
