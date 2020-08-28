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


public class RepeatedString {

    static long repeatedString(String s, long n) {

        char reapeatedChar = 'a';

        long repeatedUnitCharCount = s.chars().filter(ch -> ch == reapeatedChar).count();
        long repeatedStringCount = getRepeatedString(s, n, reapeatedChar, repeatedUnitCharCount);

//System.out.println("repeatedStringCount:"+repeatedStringCount);

        return repeatedStringCount;
    }

    private static long getRepeatedString(String s, long n, char reapeatedChar, long charCount) {
        long size = s.length();

        long repeatCount = (n/size);
        int remainder = (int)(n%size);

        long repeatedStringCount = (repeatCount * charCount) + getRemainderCount(s, reapeatedChar, remainder);

//System.out.println("repeatedStringCount:"+repeatedStringCount);

        return repeatedStringCount;
    }

    private static long getRemainderCount(String s, char reapeatedChar, int remainder) {
        long charCount = s.substring(0, remainder).chars().filter(ch -> ch == reapeatedChar).count();

        return charCount;
    }

    private static String getAddedString(String s, long repeatCount, long remainder, long n) {
        StringWriter writer = new StringWriter();

        for(long i=0; i<repeatCount; i++) {
            writer.write(s);
        }

        if(remainder > 0) {
            writer.write( s.substring(0, (int)remainder) );
        }

        return writer.toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        System.out.println(String.valueOf(result)+"\n");

        scanner.close();
    }

}