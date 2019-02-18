package com.bank.scops.backend.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AmountFormatter.class)
public class AmountFormatterTest {
    @Autowired
    private AmountFormatter amountFormatter;

    @Test
    public void isClassImpThere() {
       assertNotNull(amountFormatter);
    }

    @Test
    public void checkOutIsNotNull() {
       assertNotNull(amountFormatter.formatAmount("1995045"));
    }

    @Test
    public void oneDigitFormatter() {
       assertEquals("$1",amountFormatter.formatAmount("1"));
    }

    @Test
    public void twoDigitFormatter() {
       assertEquals("$12",amountFormatter.formatAmount("12"));
    }

    @Test
    public void threeDigitFormatter() {
       assertEquals("$123",amountFormatter.formatAmount("123"));
    }

    @Test
    public void forthDigitFormatter() {
       assertEquals("$1.234",amountFormatter.formatAmount("1234"));
    }

    @Test
    public void fiveDigitFormatter() {
       assertEquals("$12.345",amountFormatter.formatAmount("12345"));
    }

    @Test
    public void sixDigitFormatter() {
       assertEquals("$123.456",amountFormatter.formatAmount("123456"));
    }

    @Test
    public void sevenDigitFormatter() {
       assertEquals("$1.234.567",amountFormatter.formatAmount("1234567"));
    }

    @Test
    public void integrationCase12345678890() {
       assertEquals("$12.345.678.890",amountFormatter.formatAmount("12345678890"));
    }

    @Test
    public void checkUseCaseExampleHasBeenFormatted() {
       assertEquals("$1.995.045",amountFormatter.formatAmount("1995045"));
    }
}