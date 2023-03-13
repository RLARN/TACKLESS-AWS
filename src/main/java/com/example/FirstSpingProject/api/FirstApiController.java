package com.example.FirstSpingProject.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
// RestAPI용 컨트롤러! JSON을 반환!
// 일반 컨트롤러는 뷰 페이지 반환..

// 일반 컨트로러와의 차이는 일반은 뷰 탬플릿 페이지가 반환되고
// RestController 는 JSON혹은 텍스트등 데이터를 반환! 
public class FirstApiController {
    @GetMapping("api/hello")
    public String hello() {
        return "hello world";
    }
}