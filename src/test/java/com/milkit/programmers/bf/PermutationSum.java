package com.milkit.programmers.bf;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Arrays;

public class PermutationSum {

    @Test
    public void permutationSum() {

        int total = 100;
        System.out.println(solution(total));

        final int[] height = {
            20,
            7,
            23,
            19,
            10,
            15,
            25,
            8,
            13
        };
        System.out.println(solution(height, height.length-1));
    }


    private int solution(int n) {
        if(n == 1) return 1;

        return n + solution(n - 1);
    }

    private int solution(int[] height, int index) {
        if(index == 0) return height[0];

        return height[index] + solution(height, --index);
    }
    

}