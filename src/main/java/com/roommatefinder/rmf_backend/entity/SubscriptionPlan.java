package com.roommatefinder.rmf_backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "subscription_plans")
public class SubscriptionPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private SubscriptionType planType;

    @Column(nullable = false)
    private int maxConnections; // Maximum Number of connections allowed

    @Column(nullable = false)
    private double price; // Price of the plan

    @Column(nullable = false)
    private int durationInDays; // Plan validity in days

    @Column
    private String description; // Optional: More details about the plan
}
