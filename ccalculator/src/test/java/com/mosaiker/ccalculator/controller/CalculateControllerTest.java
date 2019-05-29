package com.mosaiker.ccalculator.controller;

import com.mosaiker.ccalculator.service.calculator;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculateControllerTest {
    @Test
    public void calresult() {
        calculator calculator = new calculator();
        System.out.println(calculator.cal("1+1"));
    }

}