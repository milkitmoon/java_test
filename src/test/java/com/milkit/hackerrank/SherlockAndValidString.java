package com.milkit.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.regex.*;
import java.util.stream.Collectors;

public class SherlockAndValidString {

    static String isValid(String s) {
        String result = "YES";

        try {
            validate(s);
        } catch(Exception ex) {
            return "NO";
        }
        
        List<Character> list = s.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

        Map<Character, Long> countMap = list.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

//System.out.println(countMap);

        Long min = Collections.min(countMap.values());

//System.out.println("min:"+min);

        long count = countMap.entrySet().stream().filter(x -> (x.getValue() - min) > 1).mapToLong(x -> x.getValue() - min).sum();
//        long count = countMap.entrySet().stream().filter(x -> (x.getValue() > min) ).mapToLong(x -> x.getValue() - min).sum();

System.out.println("count:"+count);

        if(count > 1) {
            result = "NO";
        }

        return result;
    }

    private static void validate(String s) throws Exception {
        int length = s.length();

        if(length >= 1 && length <= 100000) {
            if (s.matches(".*[a-z].*")) {
                return;
            }
        }

        throw new Exception();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s = scanner.nextLine();
        String result = isValid(s);

System.out.println(result+"\n");

        scanner.close();
    }

}
