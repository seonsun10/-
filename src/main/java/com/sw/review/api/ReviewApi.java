package com.sw.review.api;

import com.sw.review.api.request.CreateReviewRequest;
import com.sw.review.model.ReviewEntity;
import com.sw.review.service.RestaurantService;
import com.sw.review.service.ReviewService;
import com.sw.review.service.dto.ReviewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @GetMapping("/restaurant/{restaurantId}/reviews")
    public ReviewDto getRestaurantReviews(@PathVariable Long restaurantId, @RequestParam("offset") Integer offSet, @RequestParam("limit") Integer limit){
        return reviewService.getRestaurantReview(restaurantId, PageRequest.of(offSet / limit , limit));
    }

}
