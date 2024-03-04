package com.winerte.exception;

public class MyException extends RuntimeException{
    private String mes;
    public MyException(String mes){
        this.mes=mes;
    }
}
