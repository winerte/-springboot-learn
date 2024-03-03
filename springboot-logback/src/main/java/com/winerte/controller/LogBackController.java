package com.winerte.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogBackController {


    @GetMapping("log")
    public String logPrint() {
        Logger logger = LoggerFactory.getLogger(LogBackController.class);
        logger.info("打印日志成功{}", logger);
        return "打印日志";
    }
}
