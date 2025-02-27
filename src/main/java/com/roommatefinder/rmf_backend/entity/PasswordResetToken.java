package com.roommatefinder.rmf_backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Entity
@Getter
@Setter
public class PasswordResetToken {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private Integer otp;

  @Column(nullable = false)
  private Instant expirationTime;

  private boolean verified;

  @OneToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  public boolean isExpired() {
    return Instant.now().isAfter(expirationTime);
  }
}