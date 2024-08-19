package com.sw.review.api;

import com.sw.review.api.request.CreateAndEditRestaurantRequest;
import com.sw.review.model.RestaurantEntity;
import com.sw.review.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ResaurantApi {

    private final RestaurantService restaurantService;

    /**
     * 레스토랑 기본 조회
     * @return
     */
    @GetMapping("/restaurants")
    public String getRestaurants() {
        return "This is getRestaurants";
    }

    /**
     * 레스토랑 상세 조회
     * @param restaurantId
     * @return
     */
    @GetMapping("/restaurants/{restaurantId}")
    public String getRestaurant(@PathVariable Long restaurantId) {
        return "This is getRestaurant - id : " + restaurantId;
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
