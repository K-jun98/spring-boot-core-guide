package com.springboot.api.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/delete-api")
public class DeleteController {

    @DeleteMapping("/{variable}")
    public String DeleteVariable(@PathVariable String variable) {
        return "Delete Variable";
    }

    @DeleteMapping("/request1")
    public String getRequestParam1(@RequestParam String email) {
        return "email : " + email;
    }
}
