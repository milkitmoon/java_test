package com.milkit.programmers.dfsbfs;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Dfs {

    int count = 0;

    @Test
    public void dfs() {
        // final int[] height = { 6, 9, 5, 7, 4 };
        final int[] numbers = {2, 2, 2, 2, 1};
        final int target = 3;

        final int result = solution(numbers, target);
        System.out.println(result);

//System.out.println("count:"+count);
    }

    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, 0, 0, target);
        return answer;
    }

    private int dfs(int[] numbers, int n, int sum, int target) {

        count++;

System.out.println("n:"+n);
System.out.println("sum:"+sum);
System.out.println("target:"+target);
System.out.println("count:"+count);
System.out.println("\n");

        if(n == numbers.length) {
            if(sum == target) {
                return 1;
            }
            return 0;
        }

        int plusVal = dfs(numbers, n + 1, sum + numbers[n], target);
        int minusVal = dfs(numbers, n + 1, sum - numbers[n], target);

//System.out.println("plusVal:"+plusVal);
//System.out.println("minusVal:"+minusVal);
//System.out.println("\n");

        return plusVal+minusVal;
    }

}