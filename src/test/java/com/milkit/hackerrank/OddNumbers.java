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


class Result {


    public static List<Integer> oddNumbers(int l, int r) {

        List<Integer> result = null;
        try {
            validate(l, r);
        } catch(Exception ex) {
            return new ArrayList<Integer>();
        }
        
        int[] oddArray = IntStream.rangeClosed(l, r).filter(num -> num % 2 == 1).toArray();

        result = Arrays.stream(oddArray).boxed().collect(Collectors.toList());

        String resultStr = result.stream()
        .map(Object::toString)
        .collect(joining("\n"))
        + "\n";

//        System.out.println(resultStr);

        return result;
    }

    private static void validate(int l, int r) throws Exception {
        if(l >= 1 && l <= 100000) {
            if(r >= l && r <= 100000) {
                return;
            }
        }

        throw new Exception();
    }

}

public class OddNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(bufferedReader.readLine().trim());

        int r = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> result = Result.oddNumbers(l, r);
        
        String resultStr = result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        ;

        System.out.println(resultStr);

        bufferedReader.close();
    }
}