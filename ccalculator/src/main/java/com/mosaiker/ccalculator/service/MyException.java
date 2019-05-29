package com.mosaiker.ccalculator.service;

public class MyException extends Exception{
    private String msg;

    public MyException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}