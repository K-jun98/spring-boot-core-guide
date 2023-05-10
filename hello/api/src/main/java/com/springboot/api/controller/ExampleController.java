package com.springboot.api.controller;


import com.springboot.api.dto.MemberDto;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

@RestController
@RequestMapping("/example")
public class ExampleController {

    // @RequestParam 사용 예
    // http://localhost:8080/example/greeting?name=name
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name) {
        return "Hello, " + name;
    }

    // @PathVariable 사용 예
    @GetMapping("/users/{userId}")
    public String getUser(@PathVariable("userId") String userId) {
        // 이 부분에서 실제 사용자를 조회하는 로직을 구현
        return "User id: " + userId;
    }

    // @RequestBody 사용 예
    @PostMapping("/users")
    public String createUser(@RequestBody MemberDto memberDto) {
        // 이 부분에서 실제 사용자를 생성하는 로직을 구현
        return "User created: " + memberDto.getName();
    }

    // @RequestHeader 사용 예
    @GetMapping("/headerinfo")
    public String headerInfo(@RequestHeader("User-Agent") String userAgent) {
        System.out.println(userAgent);
        return "User-Agent: " + userAgent;
    }

    // @SessionAttribute 사용 예
    @GetMapping("/sessioninfo")
    public String sessionInfo(@SessionAttribute("username") String username, HttpSession session) {
        System.out.println(session.getId());
        return "Username in session: " + username;
    }

    @GetMapping("/users2")
    public String createUser2(@ModelAttribute MemberDto memberDto) {
        // 이 부분에서 실제 사용자를 생성하는 로직을 구현
        return "member";
    }

}
