package com.flash.regapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Component
public class StarUtil {

    @Value("${properties.starwords}")
    private String starwords;

    public String getStarwords(String text){
//      This will pull the list from the application properties file and replace the matching words, this is not case-sensitive
        List<String> list = Arrays.asList(starwords.split(","));
        Pattern pattern = Pattern.compile("\\b(" + String.join("|", list) + ")\\b", Pattern.CASE_INSENSITIVE);
        String regex = Arrays.stream(text.split(" "))
                .map(word -> pattern.matcher(word).matches() ? "*".repeat(word.length()) : word)
                .collect(Collectors.joining(" "));
        return Arrays.stream(text.split(" "))
                .map(word -> pattern.matcher(word).matches() ? "*".repeat(word.length()) : word)
                .collect(Collectors.joining(" "));
    }

}
