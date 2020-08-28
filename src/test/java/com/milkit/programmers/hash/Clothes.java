package com.milkit.programmers.hash;


import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.*;

import org.junit.Test;

public class Clothes {

    @Test
    public void phonebook() {

//        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}; 
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}, {"crow_mask", "face"}, {"smoky_makeup", "face"}}; 
//        String[][] clothes = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}; 

        System.out.println(solution(clothes));

    }


    public int solution(String[][] clothes) {
        int answer = 0;

        Map<String, Long> clothsMap = Stream.of(clothes).collect(Collectors.groupingBy(arr -> arr[1], Collectors.counting()));

        long multiply = 0;
        if(clothsMap.size() > 1) {
            multiply = clothsMap.values().stream().mapToLong(Long::longValue).reduce(1, (x, y) -> x * y);
        }

        System.out.println(clothsMap);
        System.out.println("multiply:"+multiply);

        answer = clothes.length + (int)multiply;

        return answer;
    }


}


class StatisticsUtility {
    public static int addData(Long num1, Long num2) {
        return (int)(num1 + num2);
    }
}