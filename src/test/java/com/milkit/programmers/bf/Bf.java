package com.milkit.programmers.bf;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Bf {

    @Test
    public void bf() {
//        final int[] answers = {1, 2, 3, 4, 5};
        final int[] answers = {1,3,2,4,2};

        final int[] result = solution(answers);
        for (final int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] answers) {
        int[] result = {};

        int[][] students = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int[] score = checkScore(answers, students);

 /*       
        for (final int i : score) {
            System.out.println(i);
        }
*/
        return getMaxScorer(score);
    }

    private static int[] checkScore(int[] answers, int[][] students) {
        int[] score = new int[students.length];

        for(int i = 0; i < score.length; i++) {
            for(int j = 0; j < answers.length; j++) {

                int pickIndex = (j % students[i].length);

//System.out.println("students["+i+"]["+pickIndex+"]:"+students[i][j % students[i].length]+"     answers["+j+"]:"+answers[j]);

                if(students[i][pickIndex] == answers[j]) {
                    score[i]++;
                }
            }
        }
        return score;
    }

    
    private static int[] getMaxScorer(int[] score) {
        int max = Arrays.stream(score).max().getAsInt();

        List<Integer> resultList = new ArrayList<>();

        for(int s=1; s<score.length+1; s++) {
            if(score[(s-1)] ==  max) {
                resultList.add(s);
            }
        }

        return resultList.stream().mapToInt(i->i).toArray();
        
/*
        int[] result = new int[Arrays.stream(score).filter(factor -> factor == max).toArray().length];

        int x = 0;
        for(int y = 0; y < score.length; y++){
            if(score[y] == max) {
                result[x++] = y+1;
            }
        }

        return result;
*/
    }
    
}