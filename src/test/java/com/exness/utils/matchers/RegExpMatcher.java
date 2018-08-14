package com.exness.utils.matchers;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

import java.util.regex.Pattern;

public class RegExpMatcher extends BaseMatcher<String> {
    Pattern pattern;

    public static RegExpMatcher regExp(String pattern){
        return new RegExpMatcher(pattern);
    }

    public RegExpMatcher(String pattern) {
        this.pattern = Pattern.compile(pattern);
    }

    @Override
    public boolean matches(Object o) {
        String string = (String)o;
        return pattern.matcher(string).matches();
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("Строка не соответствует регулярному выражению "+pattern.pattern());
    }
}