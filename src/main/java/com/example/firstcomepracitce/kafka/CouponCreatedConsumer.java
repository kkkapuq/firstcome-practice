package com.example.firstcomepracitce.kafka;

import com.example.firstcomepracitce.db.Coupon;
import com.example.firstcomepracitce.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CouponCreatedConsumer {

    private final CouponRepository couponRepository;
    private final Logger logger = LoggerFactory.getLogger(CouponCreatedConsumer.class);

    @KafkaListener(topics = "coupon_create", groupId = "group_1")
    public void listener(Long userId) {
        try {
            System.out.println("memberId = " + userId);
            couponRepository.save(new Coupon(userId));
        } catch (Exception e) {
            logger.error("failed to create coupon::" + userId);
        }
    }
}