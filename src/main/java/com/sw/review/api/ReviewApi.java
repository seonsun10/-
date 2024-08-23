package com.sw.review.api;

import com.sw.review.api.request.CreateReviewRequest;
import com.sw.review.model.ReviewEntity;
import com.sw.review.service.RestaurantService;
import com.sw.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ReviewApi {
    private final ReviewService reviewService;
    private final RestaurantService restaurantService;

    @PostMapping("/review")
    public void createReview(@RequestBody CreateReviewRequest reviewRequest){
        reviewService.createReview(reviewRequest.getRestaurantId(), reviewRequest.getContent(), reviewRequest.getScore());
    }

    @DeleteMapping("/review/{reviewId}")
    public void deleteReview(@PathVariable Long reviewId){
        reviewService.deleteReview(reviewId);
    }

}
