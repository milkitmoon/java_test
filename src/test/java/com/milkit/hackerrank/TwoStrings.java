package com.milkit.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;



public class TwoStrings {

    static String twoStrings(String s1, String s2) {

        List<Character> s1List = s1.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        List<Character> s2List = s2.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

        Set<Character> s1Set = new HashSet<>(s1List);
        Set<Character> s2Set = new HashSet<>(s2List);

        boolean anyMatch = s1List.stream().anyMatch(s2List::contains);

//System.out.println("anyMatch:"+anyMatch);

        return (anyMatch ? "YES" : "NO");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            System.out.println(result+"\n");
        }

        scanner.close();
    }
}
