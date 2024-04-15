package com.springboot.api.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/delete-api")
public class DeleteController {

    // http://localhost:8080/api/v1/delete-api/{String 값}
    @DeleteMapping("/{variable}")
    public String DeleteVariable(@PathVariable String variable){
        return variable;
    }

    // http://localhost:8080/api/v1/delete-api/request1?email=value
    @DeleteMapping("/request1")
    public String DeleteVariableParam1(@RequestParam String email){
        return "e-mail : " + email;
    }
}
