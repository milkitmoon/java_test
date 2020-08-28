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


public class SockMerchant {

    static int sockMerchant(int n, int[] ar) {

        List<Integer> list = Arrays.stream(ar).boxed().collect(Collectors.toList());
        
        try {
            validate(n, list);
        } catch(Exception ex) {
            return 0;
        }

        Map<Integer, Long> countMap = list.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        int count = getPairSockCount(countMap);

        return count;
    }

    private static void validate(int n, List<Integer> list) throws Exception {
        if(n >= 1 && n <= 100) {

//            boolean contains = list.stream().anyMatch(t -> (t.intValue() >= 1 && t.intValue() <= 100));

            if( list.stream().anyMatch(t -> (t.intValue() >= 1 && t.intValue() <= 100)) ) {
                return;
            }
        }

        throw new Exception();
    }

    private static int getPairSockCount(Map<Integer, Long> countMap) {
        int pairSockCount = 0 ;
        for( Map.Entry<Integer, Long> elem : countMap.entrySet() ) {
            long value = elem.getValue();
            if(value > 1) {

//System.out.println((value / 2) >> 0);
                pairSockCount += (value / 2) >> 0;
            }
        }

        return pairSockCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}