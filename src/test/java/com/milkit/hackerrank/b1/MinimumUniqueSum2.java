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


class Result2 {

    public static int getMinimumUniqueSum(List<Integer> arr) {
        int sum = 0;

//        int legnth = arr.size();
        ArrayList < Integer > uniqueList = new ArrayList < Integer > (arr.size());
        uniqueList.sort((s1, s2) -> s1.intValue() - s2.intValue());
        
        uniqueList.add(arr.get(0));

        makeUniqueList(arr, uniqueList);

//System.out.println(uniqueList);

        sum = uniqueList.stream().mapToInt(Integer::intValue).sum();

//System.out.println(sum);

        return sum;
    }


    private static void makeUniqueList(List<Integer> arr, ArrayList<Integer> resultList) {
        for (int i = 1; i < arr.size(); i++) {
            int currVal = arr.get(i);

//System.out.println("currVal:"+currVal);

            while (resultList.contains(currVal)) {
                currVal++;
            }

            resultList.add(currVal);
        }
    }

}

public class MinimumUniqueSum2 {
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

        int result = Result2.getMinimumUniqueSum(arr);

        System.out.println(String.valueOf(result)+"\n");

        bufferedReader.close();
    }
}