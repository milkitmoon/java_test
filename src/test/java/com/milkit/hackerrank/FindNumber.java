package com.milkit.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FindNumber {

    private static final String YES = "YES";
    private static final String NO = "NO";

    public static String findNumber(List<Integer> arr, int k) {
        String result = FindNumber.YES;
        
        try {
            validate(arr, k);
        } catch(Exception ex) {
            result = FindNumber.NO;
        }

//        boolean contains = arr.stream().anyMatch(t -> (t.intValue() > 1 && t.intValue() > 1000000000));
        boolean contains = arr.stream().anyMatch(t -> (t.intValue() == k));
        if (!contains) {
            result = FindNumber.NO;
        }

        return result;
    }
    
    private static void validate(List<Integer> arr, int k) throws Exception {
        if(arr.size() < 1 || arr.size() > 100000) {
            throw new Exception();
        }

        if( arr.stream().anyMatch(t -> (t.intValue() < 1 || t.intValue() > 1000000000)) ) {
            throw new Exception();
        }
    }

    public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    
            int arrCount = Integer.parseInt(bufferedReader.readLine().trim());
    
            List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
                try {
                    return bufferedReader.readLine().replaceAll("\\s+$", "");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());
    
            int k = Integer.parseInt(bufferedReader.readLine().trim());
    
            String result = FindNumber.findNumber(arr, k);
    
            System.out.println(result);
    
            bufferedReader.close();
        }

}