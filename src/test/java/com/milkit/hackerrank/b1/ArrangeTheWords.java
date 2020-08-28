package com.milkit.hackerrank.b1;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;



class Result {


    public static String arrange(String sentence) {

        List<String> items = Arrays.asList(sentence.toLowerCase().replace(".", "").split(" "));
        items.sort((s1, s2) -> s1.length() - s2.length());

        makeForm(items);

//        System.out.println(items);

        return listToString(items);
    }


    private static String listToString(List<String> items) {
        StringBuffer buff = new StringBuffer();

        for(String item : items) {
            buff.append(item).append(" ");
        }

        String result = buff.toString();

        if(result != null && result.length() > 1) {
            result.substring(0, result.length() - 1);
        }

        return result;
    }

    private static void makeForm(List<String> items) {
        items.set(0, uppperCase(items.get(0)));
        int endIndex = items.size()-1;
        items.set(endIndex, items.get(endIndex)+".");
    }

    private static String uppperCase(String str) {
        if(str == null || str.isEmpty()) {
            return str;
        }
    
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

}

public class ArrangeTheWords {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String sentence = bufferedReader.readLine();

        String result = Result.arrange(sentence);

        System.out.println(result+"\n");

        bufferedReader.close();
    }
}
