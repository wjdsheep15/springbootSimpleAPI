package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    private final Logger LOGGER = LoggerFactory.getLogger(GetController.class);

    // https://localhost:8080/api/vi/get-api/hello
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello() {
        LOGGER.info("getHello 메서드가 호출 되었습니다.");
        return "Hello World";

    }

    // http://localhost:8008/api/v1/get-api/name
    @GetMapping(value = "/name")
    public String getName(){
        LOGGER.info("getName 메서드가 호출 되었습니다.");
        return "Flautere";
    }

    // http://localhost:8008/api/v1/get-api/variable1/{String 값}
    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable){
        LOGGER.info("@PathVariable을 통해 들어오는 값 : {}", variable);
        return variable;
    }

    // http://localhost:8008/api/v1/get-api/variable2/{String 값}
    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var){
        return var;
    }

    // http://localhost:8008/api/v1/get-api/request1?name=value1&email=value2&organization=value3
    @GetMapping(value="/request1")
    public String getRequestParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization){
        return name + " " + email + " " + organization;
    }

    // http://localhost:8008/api/v1/get-api/request2?key=1value1&key2=value2
    @GetMapping(value="/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param){
        StringBuilder sb= new StringBuilder();

        param.entrySet().forEach(map ->{
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    // http://localhost:8008/api/v1/get-api/request3?name=value1&email=value2&organization=value3
    @GetMapping("/request3")
    public String getRequestParam3(MemberDto memberDto){
        return memberDto.getName() + " " + memberDto.getEmail() + " " + memberDto.getOrganization();
        //return memberDto.toString();
    }
}