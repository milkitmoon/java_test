package com.milkit.hackerrank.k1;

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

    public static List<List<Integer>> groupSort(List<Integer> arr) {
    // Write your code here

        try {
            validate(arr);
        } catch(Exception ex) {
            return new ArrayList<List<Integer>>() ;
        }

        Map<Integer, Long> summaryMap = arr.stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<Integer, Long> summaryMap2 = summaryMap.entrySet()
             .stream()
             .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
             .collect(Collectors.toMap(
               Map.Entry::getKey,
               Map.Entry::getValue,
               (e1, e2) -> e1,
               LinkedHashMap::new
             ));


//System.out.println(summaryMap2);

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Integer[][] summaryArray = summaryMap2.entrySet()
                            .stream()
                            .map(e -> new Integer[]{e.getKey(), (int) (long)e.getValue()})
                            .toArray(Integer[][]::new);

        result = Arrays.stream(summaryArray).map(Arrays::asList).collect(Collectors.toList());



/*        
        for(Map.Entry<Integer, Long> entry : summaryMap2.entrySet()){

            List<Integer> inner = new ArrayList<Integer>();
            inner.add(entry.getKey() );
            inner.add( (int) (long)entry.getValue() );

            result.add(inner);
            
        }
*/

        return result;
    }

    private static void validate(List<Integer> arr) throws Exception {
        if(arr.size() < 1 || arr.size() > 100000) {
            throw new Exception();
        }

        if( arr.stream().anyMatch(t -> (t.intValue() < 1 || t.intValue() > 100000)) ) {
            throw new Exception();
        }
    }

}

public class SortTheSummary2 {
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

        List<List<Integer>> result = Result2.groupSort(arr);

        result.stream()
            .map(
                r -> r.stream()
                    .map(Object::toString)
                    .collect(joining(" "))
            )
            .map(r -> r + "\n")
            .collect(toList())
            .forEach(e -> {
                try {
                    System.out.println(e);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            });

        bufferedReader.close();
    }
}