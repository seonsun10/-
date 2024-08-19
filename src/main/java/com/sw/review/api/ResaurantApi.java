package com.sw.review.api;

import com.sw.review.api.request.CreateAndEditRestaurantRequest;
import com.sw.review.api.response.RestaurantDetailView;
import com.sw.review.api.response.RestaurantView;
import com.sw.review.model.RestaurantEntity;
import com.sw.review.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class ResaurantApi {

    private final RestaurantService restaurantService;

    /**
     * 레스토랑 기본 조회
     * @return
     */
    @GetMapping("/restaurants")
    public List<RestaurantView> getRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    /**
     * 레스토랑 상세 조회
     * @param restaurantId
     * @return
     */
    @GetMapping("/restaurants/{restaurantId}")
    public RestaurantDetailView getRestaurant(@PathVariable Long restaurantId) {
        return restaurantService.getRestaurantDetail(restaurantId);
    }


    /**
     * 레스토랑 생성
     * @param request
     * @return
     */
    @PostMapping("/restaurant")
    public void createRestaurant(@RequestBody CreateAndEditRestaurantRequest request) {
        restaurantService.createRestaurant(request);
    }

    /**
     * 레스토랑 수정
     * @param restaurantId
     * @return
     */
    @PutMapping("/restaurant/{restaurantId}")
    public void editRestaurant(@PathVariable Long restaurantId,@RequestBody CreateAndEditRestaurantRequest request) {
        restaurantService.editRestaurant(restaurantId, request);
    }

    /**
     * 레스토랑 삭제
     * @param restaurantId
     * @return
     */
    @DeleteMapping("/restaurant/{restaurantId}")
    public void deleteRestaurant(@PathVariable Long restaurantId) {
        restaurantService.deleteRestaurant(restaurantId);
    }

}
