package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/get-api")
public class GetController {

    //http://localhost:8080/api/v1/get-api/hello
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getName() {
        log.info("getName 호출");
        return "Jun";
    }

    @GetMapping("/variable1/{variable}")
    public String getVariable1(@PathVariable("variable") String value) {
        return value;
    }

    @GetMapping("/variable1")
    @Operation(summary = "Some API", description = "설명")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공"),
            @ApiResponse(responseCode = "fail")})
    public String getRequestParam(@ApiParam(value = "이름", required = true) @RequestParam String name,
                                  @ApiParam(value = "이메일", required = true)@RequestParam String email,
                                  @ApiParam(value = "회사", required = true)@RequestParam String organization) {
        return name + " " + email + " " + organization;
    }

    @GetMapping("/variable2")
    public String getRequestParam2(@RequestParam Map<String, String> requestParams) {
        StringBuilder sb = new StringBuilder();
        requestParams.entrySet().forEach(map -> sb.append(map.getKey() + " : " + map.getValue() + "\n"));
        return sb.toString();
    }

    @GetMapping("/variable3")
    public String getRequestParam3(MemberDto memberDto) {
        return memberDto.toString();
    }

}
