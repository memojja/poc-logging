package com.example.demo.controller;

import com.example.demo.anno.Profiled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeyController {

    @Profiled
    @RequestMapping("/hey")
    public String hey(){
        return "HEY!";
    }

}
