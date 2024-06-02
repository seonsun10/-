package com.sw.review.api;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestRequestApi {

    //Request Parameter 방식
    @GetMapping("/test/param")
    public String requestParam(@RequestParam("name") String name, @RequestParam("age") int age){
        return "Hello Request Param! I am " + name + " and "+age+" years old";
    }

    //Path Variable 방식
    @GetMapping("/test/path/{name}/{age}")
    public String requestPathVariable(@PathVariable("name") String name, @PathVariable("age") int age){
        return "Hello, Path Variable! I am " + name + " and "+age+" years old";
    }

    //Request Body 방식
    @PostMapping("/test/body")
    public String requestBody(@RequestBody TestRequestBody request){
        return "Hello Request Body! : "+ request.name + " and "+request.age+" years old";
    }

    public static class TestRequestBody {
        String name;
        Integer age;

        public TestRequestBody(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }
}
