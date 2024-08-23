package com.sw.review.service;

import com.sw.review.model.ReviewEntity;
import com.sw.review.repository.RestaurantRepository;
import com.sw.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;

@RequiredArgsConstructor
@Service
public class ReviewService {
    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;


    @Transactional
    public void createReview(Long restaurantId, String content, Double score) {
        restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("없는 레스토랑입니다."));

        ReviewEntity review = ReviewEntity.builder()
                .restaurantId(restaurantId)
                .content(content)
                .score(score)
                .createdAt(ZonedDateTime.now())
                .build();

        reviewRepository.save(review);
    }

    @Transactional
    public void deleteReview(Long reviewId) {
        ReviewEntity review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new RuntimeException("없는 리뷰입니다."));

        reviewRepository.delete(review);
    }
}
