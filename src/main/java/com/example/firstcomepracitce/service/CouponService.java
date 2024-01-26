package com.example.firstcomepracitce.service;

import com.example.firstcomepracitce.db.Coupon;
import com.example.firstcomepracitce.kafka.CouponCreateProducer;
import com.example.firstcomepracitce.repository.AppliedMemberRepository;
import com.example.firstcomepracitce.repository.CouponCountRepository;
import com.example.firstcomepracitce.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CouponService {

    private final CouponRepository couponRepository;
    private final CouponCountRepository couponCountRepository;
    private final CouponCreateProducer couponCreateProducer;
    private final AppliedMemberRepository appliedMemberRepository;

    public void apply(Long userId) {
        Long apply = appliedMemberRepository.add(userId);

        if (apply != 1) {
            return;
        }

        Long count = couponCountRepository.increase();

        if (count > 100) {
            return;
        }

        couponCreateProducer.create(userId);
    }
}