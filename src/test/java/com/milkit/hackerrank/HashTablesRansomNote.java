package com.milkit.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.function.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

public class HashTablesRansomNote {

    static void checkMagazine(String[] magazine, String[] note) {

        String result = "No";
        Map<String, Long> magazineMap = Arrays.stream(magazine)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<String, Long> noteMap = Arrays.stream(note)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

System.out.println(magazineMap);
System.out.println(noteMap);
//        boolean isContains = magazineMap.entrySet().containsAll(noteMap.entrySet());

 
        long count = noteMap
            .entrySet()
            .stream()
            .filter(entry -> magazineMap.containsKey(entry.getKey())).count();
    

        boolean isContains = noteMap.entrySet()
            .stream()
            .allMatch(e -> e.getValue().equals(magazineMap.get(e.getKey())));

        if(isContains) {
            result = "Yes";
        }

        System.out.println( result );
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}