package com.milkit.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class VeryBigSum {


static long aVeryBigSum(long[] ar) {
    long bigSum = 0l;

    if(ar != null) {
        for(long ele : ar) {
            bigSum = bigSum+ele;
        }
    }
    return bigSum;
}

private static final Scanner scanner = new Scanner(System.in);

public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\temp\\test.txt"));

    int arCount = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    long[] ar = new long[arCount];

    String[] arItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < arCount; i++) {
        long arItem = Long.parseLong(arItems[i]);
        ar[i] = arItem;
    }

    long result = aVeryBigSum(ar);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
}
}