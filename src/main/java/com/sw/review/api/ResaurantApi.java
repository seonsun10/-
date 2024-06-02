package com.sw.review.api;

import com.sw.review.api.request.CreateAndEditRestaurantRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class ResaurantApi {



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
    public String createRestaurant(@RequestBody CreateAndEditRestaurantRequest request) {
        return "This is createRestaurant, name = " + request.getName() + ", address = " + request.getAddress() + ", 1번메뉴 : = " + request.getMenus().get(0).getName();
    }

    /**
     * 레스토랑 수정
     * @param restaurantId
     * @return
     */
    @PutMapping("/restaurant/{restaurantId}")
    public String editRestaurant(@PathVariable Long restaurantId,@RequestBody CreateAndEditRestaurantRequest request) {
        return "This is createRestaurant, name = " + request.getName() + ", address = " + request.getAddress() + ", 2번메뉴 : = " + request.getMenus().get(0).getName();
    }

    /**
     * 레스토랑 삭제
     * @param restaurantId
     * @return
     */
    @DeleteMapping("/restaurant/{restaurantId}")
    public String deleteRestaurant(@PathVariable Long restaurantId) {
        return "This is deleteRestaurant - id : " + restaurantId;
    }

}
