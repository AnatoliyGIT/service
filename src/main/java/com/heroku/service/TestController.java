package com.heroku.service;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class TestController {
    @ApiOperation(value = "Get user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = User.class),
            @ApiResponse(code = 400, message = "Error! Bad request"),
            @ApiResponse(code = 401, message = "Error! Wrong authorization"),
            @ApiResponse(code = 404, message = "Error! Car with give serial number not found!")
    })
    @GetMapping(value = "/init")
    public User home() {
        return new User("User",22);
    }

    @ApiOperation(value = "Registration new user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = User.class),
            @ApiResponse(code = 400, message = "Error! Bad email or password"),
            @ApiResponse(code = 403, message = "Error! Forbidden"),
            @ApiResponse(code = 409, message = "Error! User already exist")
    })

    @PostMapping(value = "/registration")
    public User registrationUser(@RequestBody User registrationDto
            , @RequestHeader("Authorization") String token) {
        return registrationDto;
    }

    @ApiOperation(value = "login user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = User.class),
            @ApiResponse(code = 400, message = "Error! Bad email or password"),
            @ApiResponse(code = 403, message = "Error! Forbidden"),
            @ApiResponse(code = 409, message = "Error! User already exist")
    })
    @PostMapping(value = "/login")
    public String registrationUser(@RequestHeader("Authorization") String token) {
        return token;
    }
}
