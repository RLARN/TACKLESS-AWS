package com.example.FirstSpingProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi") //url 연결 요청 .. 클라이언트로 부터컨트롤러가 요청
    public String  niceToMeetYou(Model model){
        model.addAttribute("username", "Mr.kimchi ");
        return "greetings"; //templates/greetings.mustache 브라우저로 전송(뷰페이지 찾는다)
        //hi 라는 url을 입력받으면 그리팅스 파일을 찾아서 브라우저로 전송 한다.
        //그리팅스는 뷰페이지의 이름
        //변수 사용을 위해 모델을 거쳐야 한다.
    }

    @GetMapping("/bye")
    public String seeYouNext(Model model){
        model.addAttribute("nickname","gildong ");//모델이라는 객채가 밸류를 nickname에 전송 
        return "goodbye";
    }
}
