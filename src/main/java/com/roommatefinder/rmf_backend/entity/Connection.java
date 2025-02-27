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
@Table(name = "connections")
public class Connection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // The user who sent the request

    @ManyToOne
    @JoinColumn(name = "connected_user_id", nullable = false)
    private User connectedUser; // The user who accepted/rejected the request

    @Column(length = 300)
    private String requestNote; // Optional note from sender

    private Instant connectionDate;

    @Enumerated(EnumType.STRING)
    private ConnectionStatus status; // PENDING, APPROVED, REJECTED

    /**
     * Ensures only subscribed users can send notes.
     */
    public void setRequestNote(String note) {
        if (user.getSubscriptionPlan() == null) {
            throw new IllegalArgumentException("Only subscribed users can send a note.");
        }
        this.requestNote = note;
    }

    public enum ConnectionStatus {
        PENDING,
        APPROVED,
        REJECTED
    }
}
