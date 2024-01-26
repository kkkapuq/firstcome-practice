package com.example.firstcomepracitce.db;

import jakarta.persistence.*;
import lombok.Getter;

@Entity(name = "coupon")
@Getter
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private Long userId;

    public Coupon() {
    }

    public Coupon(Long userId) {
        this.userId = userId;
    }
}