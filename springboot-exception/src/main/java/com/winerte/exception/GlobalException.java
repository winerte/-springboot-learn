package com.winerte.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler
    public String handleException(MyException e)
    {
        e.getMessage();
        return "error";
    }

    @ExceptionHandler
    public String handle(RuntimeException e)
    {
        System.out.println("进入");

        return "发生异常";
    }
}
