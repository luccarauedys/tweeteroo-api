package com.tweeteroo.api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Tweets")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tweet {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column
  private String avatar;

  @Column(length = 20, nullable = false)
  private String username;

  @Column(length = 280, nullable = false)
  private String text;
}
