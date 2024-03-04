package com.winerte.controller;

import com.winerte.exception.MyException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceController {

    @GetMapping("/test")
    public String test(){

            int i = 1/0;



        return "success";
    }
}
