package com.tweeteroo.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweeteroo.api.models.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

}
