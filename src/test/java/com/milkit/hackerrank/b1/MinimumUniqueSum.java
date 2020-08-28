package com.milkit.hackerrank.b1;

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


class Result1 {


    public static int getMinimumUniqueSum(List<Integer> arr) {
        int initVal = arr.get(0);

        int sum = initVal;
        int prev = initVal;
    
        for( int i = 1; i < arr.size(); i++ ) {
            int curr = arr.get(i);
    
            if( prev == curr ) {
                curr = curr+1;
                sum += curr;
            }
            else {
                sum += curr;
            }
            prev = curr;
        }
    
        return sum;

    }

}

public class MinimumUniqueSum {
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

        int result = Result1.getMinimumUniqueSum(arr);

        System.out.println(String.valueOf(result)+"\n");

        bufferedReader.close();
    }
}