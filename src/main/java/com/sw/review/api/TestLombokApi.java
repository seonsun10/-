package com.sw.review.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestLombokApi {

    @GetMapping("/test/lombok")
    public TestLombokResponseBody testLombok() {
        return new TestLombokResponseBody("seonwoo", 26);
    }


    @Getter
    @AllArgsConstructor //롬복 생성자 자동 생성
    public static class TestLombokResponseBody {
        String name;
        Integer age;
    }
}
