package com.sw.review.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sw.review.model.QReviewEntity;
import com.sw.review.model.ReviewEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class ReviewRepositoryImpl implements ReviewRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Double getAvgScoreByRestaurantId(Long restaurantId) {
        return jpaQueryFactory.select(QReviewEntity.reviewEntity.score.avg())
                .from(QReviewEntity.reviewEntity)
                .where(QReviewEntity.reviewEntity.restaurantId.eq(restaurantId))
                .fetchFirst();
    }

    @Override
    public Slice<ReviewEntity> findSliceByRestaurantId(Long restaurantId, Pageable pageable) {
        List<ReviewEntity> reviews = jpaQueryFactory.select(QReviewEntity.reviewEntity)
                .from(QReviewEntity.reviewEntity)
                .where(QReviewEntity.reviewEntity.restaurantId.eq(restaurantId))
                .offset((long)pageable.getPageNumber() * pageable.getPageSize())
                .limit(pageable.getPageSize() + 1)
                .fetch();

        return new SliceImpl<>(
                    reviews.stream().limit(pageable.getPageSize()).toList(),
                    pageable,
                    reviews.size() > pageable.getPageSize()
                );
    }
}
