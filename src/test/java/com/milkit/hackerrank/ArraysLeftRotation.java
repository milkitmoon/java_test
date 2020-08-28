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


public class ArraysLeftRotation {

    static int[] rotLeft(int[] a, int d) {

/*
for (int i = 0; i < a.length; i++) {
    System.out.println(a[i]);
}
System.out.println(d);
*/

/*
        for (int i = d-1; i >= 0; i--) {                
            a[i+1] = a[i];
        }
*/

        List<Integer> shiftList = shiftLeft(a, d);
        return shiftList.stream().mapToInt(i->i).toArray();

//        leftRotateArray(a, d);
//        return a;
    }

    private static List<Integer> shiftLeft (int [] a, int d) {

        List<Integer> intList = Arrays.stream(a).boxed().collect(Collectors.toList());

/*        
        List<Integer> intList = new ArrayList<Integer>();
      
        for (int index = 0; index < a.length; index++) {
            intList.add(a[index]);
        }
*/      
        Collections.rotate(intList, -1 * d);

        return intList;
    }

    private static void leftRotateArray(int arr[], int d) {
        for (int i = 0; i < d; i++) {
            int j; 
            int temp = arr[0];

            for (j = 0; j < arr.length-1; j++) {
                arr[j] = arr[j + 1];
            }
            arr[j] = temp; 
        }
    } 

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

        for (int i = 0; i < result.length; i++) {
            System.out.println(String.valueOf(result[i]));

            if (i != result.length - 1) {
                System.out.println(" ");
            }
        }

        System.out.println("\n");

        scanner.close();
    }

}