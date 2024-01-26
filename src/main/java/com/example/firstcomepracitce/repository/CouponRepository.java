package com.example.firstcomepracitce.repository;

import com.example.firstcomepracitce.db.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
}
