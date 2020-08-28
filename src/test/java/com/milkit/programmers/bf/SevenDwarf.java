package com.milkit.programmers.bf;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Arrays;

public class SevenDwarf {

    @Test
    public void sevenDwarf() {
//        final int[] numbers = {1, 2, 3, 4, 5};
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
        int dwarfNum = 9;
        int totalheight = 100;

        final int[] result = solution(height, dwarfNum, totalheight);
        for (final int i : result) {
            System.out.println(i);
        }
    }

    public int[] solution(int[] height, int dwarfNum, int totalheight) {
       
        int sum = sum(height, height.length-1);
       
        solution(height, dwarfNum, sum, totalheight);

        return Arrays.stream(height).filter(num -> num != -1).sorted().toArray();  
    }

    private int sum(int[] height, int index) {
        if(index == 0) return height[0];
        return height[index] + sum(height, --index);
    }

    private void solution(int[] height, int dwarfNum, int sum, int totalheight) {
        for (int i=0; i<dwarfNum-1; i++) {
            for (int j=i+1; j<dwarfNum; j++) {

//System.out.println("height["+i+"]:"+height[i]+"  height["+j+"]:"+height[j]);
                if ( (sum - (height[i] + height[j])) == totalheight) {
                    height[i] = height[j] = -1;
                    return;
                }
            }
        }
        return;
    }
   

}