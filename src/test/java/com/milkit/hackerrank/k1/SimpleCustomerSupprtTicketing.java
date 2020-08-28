package com.milkit.hackerrank.k1;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SimpleCustomerSupprtTicketing {


    static String[] braces(String[] values) {
        String[] result = new String[values.length];

        for(int i=0; i<values.length; i++) {
            result[i] = getCheckBraces(values[i]);
        }

        return result;
    }

    private static String getCheckBraces(String braces) {

        if ((braces.length() % 2) == 1) return "NO";

        Stack<Character> stack  = new Stack<Character>();

        for(int i = 0; i < braces.length(); i++) {
            char c = braces.charAt(i);

            if(c == '[' || c == '(' || c == '{' ) {     
                stack.push(c);
            } else if(c == ']') {
                if(stack.isEmpty() || stack.pop() != '[') return "NO";
            } else if(c == ')') {
                if(stack.isEmpty() || stack.pop() != '(') return "NO";
            } else if(c == '}') {
                if(stack.isEmpty() || stack.pop() != '{') return "NO";
            }

        }

        return (stack.isEmpty() ? "YES" : "NO");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int valuesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] values = new String[valuesCount];

        for (int i = 0; i < valuesCount; i++) {
            String valuesItem = scanner.nextLine();
            values[i] = valuesItem;
        }

        String[] res = braces(values);

        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);

            if (i != res.length - 1) {
                System.out.println("\n");
            }
        }

        System.out.println();

        scanner.close();
    }
}