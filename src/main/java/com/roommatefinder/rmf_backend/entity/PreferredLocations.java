package com.roommatefinder.rmf_backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "preferred_locations")
public class PreferredLocations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private String state;
    private String country;
    private String zipCode;

    private double latitude;
    private double longitude;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
