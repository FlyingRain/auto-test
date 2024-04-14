package com.flyingrain.domain.test;

import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

    @Test
    public void testRegex() {
        String reg = "[\\w,_,0-9]+\\[\\d\\]";
        Pattern pattern = Pattern.compile(reg);
        String str = "ar_ray()";
        String tt = "asdf1[1]";
        Matcher matcher = pattern.matcher(tt);
        boolean isMatch = matcher.matches();

        boolean temp = str.endsWith("()");
        System.out.println(isMatch);
    }

}
