package com.milkit.programmers.stackqueue;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Top2 {

    @Test
    public void top() {
        // final int[] height = { 6, 9, 5, 7, 4 };
        final int[] height = {3,9,9,3,5,7,2};

        final int[] retult = solution(height);
        for (final int i : retult) {
            System.out.println(i);
        }
    }

    public int[] solution(int[] heights) {
        int n = heights.length;
        int[] answer = new int[n];

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            stack.push(heights[i]);
        }

        for(int i = n-1; i >= 0; i--) {
            int tx = stack.pop();
            int idx = 0;
            while(!stack.isEmpty()) {
                int rx = stack.pop();
                idx++;
                if(rx > tx) {
                    answer[i] = i-idx+1;
                    break;
                }
            }
            for(int j = i-idx; j < i; j++) {
                stack.push(heights[j]);
            }
        }
        return answer;
    }

}