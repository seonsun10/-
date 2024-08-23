package com.sw.review.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
@AllArgsConstructor
public class CreateReviewRequest {
    private final Long restaurantId;
    private final String content;
    private final Double score;
}
