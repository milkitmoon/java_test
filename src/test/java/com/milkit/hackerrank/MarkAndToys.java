package com.milkit.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;



public class MarkAndToys {

    static int maximumToys(int[] prices, int k) {

        Arrays.sort(prices); 

        for(int i=0; i<prices.length; i++) {
            System.out.print(prices[i]+","+"\n");
        }



        return getMinIndex(prices, k);
    }

    private static int getMinIndex(int[] prices, int k) {
        int sum = 0;
        for(int i=0; i<prices.length; i++) {
            sum = sum+prices[i];

            if(sum >= k) {
                return i;
            }
        }

        return prices.length+1;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] prices = new int[n];

        String[] pricesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pricesItem = Integer.parseInt(pricesItems[i]);
            prices[i] = pricesItem;
        }

        int result = maximumToys(prices, k);

        System.out.println(String.valueOf(result)+"\n");

        scanner.close();
    }
}
