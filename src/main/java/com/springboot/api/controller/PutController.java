package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {

    // http://localhost:8080/api/v1/put-api/member
    @PutMapping("member")
    public String postMember(@RequestBody Map<String, Object> putData){
        StringBuilder sb = new StringBuilder();

        putData.entrySet().forEach(map ->{
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }

    // http://localhost:8080/api/v1/put-api/member1
    @PutMapping("member1")
    public String postMember1(@RequestBody MemberDto memberDto){
        return memberDto.toString();
    }

    // http://localhost:8080/api/v1/put-api/member2
    @PutMapping("member2")
    public MemberDto postMember2(@RequestBody MemberDto memberDto){
        return memberDto;
    }

}
