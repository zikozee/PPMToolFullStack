package com.zikozee.ppmtool.utility;

import org.springframework.util.StringUtils;

public class Utility {
    private Utility(){}

    public static String toUpperCaseNullable(String value){
        return StringUtils.hasText(value) ? value.toUpperCase().trim() : value;
    }
}
