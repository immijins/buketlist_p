package com.example.buketlist.controller.fomatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class CheckboxFormatter implements Formatter<Boolean> { // checkbox 관련 Formatter 지정
    @Override
    public Boolean parse(String text, Locale locale) throws ParseException {
        if (text == null) {
            return false;
        }
        return text.equals("on");
    }

    @Override
    public String print(Boolean object, Locale locale) {
        return object.toString();
    }
}
