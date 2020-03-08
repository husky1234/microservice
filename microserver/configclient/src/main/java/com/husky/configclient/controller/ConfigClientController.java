package com.husky.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {

    private String profile = "microserver";

    @GetMapping("/profile")
    public String hello(){
        return this.profile;
    }
}
