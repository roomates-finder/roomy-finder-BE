package com.roommatefinder.rmf_backend.entity;

public enum RoleType {
    NORMAL_USER,      // Default user with 3 connections
    SUBSCRIBED_USER,  // Has a subscription with extended limits
    ADMIN             // Has full control over the system
}
