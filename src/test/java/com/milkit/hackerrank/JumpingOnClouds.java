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


public class JumpingOnClouds {

    static int jumpingOnClouds(int[] c) {

        int steps = 0;
        int nextIndex = 0;

        try {
            validate(c);
        } catch(Exception ex) {
            return 0;
        }

        while (nextIndex < c.length-1) {
            nextIndex = stepCount(c, nextIndex);

System.out.println(nextIndex);

            steps++;
        }

        return steps;
    }

    private static void validate(int[] c) throws Exception {
        int count = c.length;

        List<Integer> list = Arrays.stream(c).boxed().collect(Collectors.toList());

        if(count >= 2 && count <= 100) {
            if (list.stream().anyMatch(t -> (t.intValue() == 0 || t.intValue() == 1))) {
                if(c[0] == 0 && c[count-1] == 0) {
                    return;
                }
            }
        }

        throw new Exception();
    }

    private static int stepCount(int[] c, int index) {
        int nextStepIdx = index+1;
        int nextStep2Idx = index+2;

        if(nextStepIdx >= c.length) {
            return index;
        }

        if(nextStep2Idx >= c.length) {
            return nextStepIdx;
        }

        int nextStep = c[nextStepIdx];
        int nextStep2 = c[nextStep2Idx];

        if(nextStep2 != 1) {
            return nextStep2Idx;
        } else {
            return nextStepIdx;
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);

        System.out.println(String.valueOf(result)+"\n");

        scanner.close();
    }

}