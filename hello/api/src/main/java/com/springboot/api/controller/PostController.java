package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/post-api")
public class PostController {

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String postHello() {
        return "Hello Post API";
    }

    @PostMapping("/member")
    public String postMember(@RequestBody Map<String, Object> postData) {
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map -> sb.append(map.getKey() + " : " + map.getValue()));
        return sb.toString();
    }

    @PostMapping("/member2")
    public String postMember(@RequestBody MemberDto memberDto) {
        return memberDto.toString();
    }

}
