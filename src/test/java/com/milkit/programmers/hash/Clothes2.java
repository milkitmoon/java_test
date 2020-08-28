package com.milkit.programmers.hash;


import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.*;

import org.junit.Test;

public class Clothes2 {

    @Test
    public void phonebook() {

//        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}; 
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}, {"crow_mask", "face"}, {"smoky_makeup", "face"}}; 
//        String[][] clothes = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}; 
//        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}}; 

        System.out.println(solution(clothes));

    }


    public int solution(String[][] clothes) {
        int answer = 0;

        Map<String, Long> clothsMap = Stream.of(clothes).collect(Collectors.groupingBy(arr -> arr[1], Collectors.counting()));

        long multiply = clothsMap.values().stream().mapToLong(Long::longValue).reduce(1, (x, y) -> x * (y + 1));

        System.out.println(clothsMap);
        System.out.println("multiply:"+multiply);

        answer = (int)multiply-1;

        return answer;
    }


}

