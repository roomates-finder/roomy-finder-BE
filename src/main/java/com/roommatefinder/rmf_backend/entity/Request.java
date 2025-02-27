package com.roommatefinder.rmf_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    private RequestType requestType;

    private Instant requestDate;

    @Enumerated(EnumType.STRING)
    private String status;

    public boolean isExpired() {
        return Instant.now().isAfter(requestDate.plusSeconds(30 * 24 * 60 * 60)); // 30 days expiry
    }
}
