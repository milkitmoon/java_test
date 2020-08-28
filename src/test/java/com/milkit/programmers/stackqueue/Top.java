package com.milkit.programmers.stackqueue;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Top {

    @Test
    public void top() {
        // final int[] height = { 6, 9, 5, 7, 4 };
        final int[] height = {3,9,9,3,5,7,2};

        final int[] retult = solution(height);
        for (final int i : retult) {
            System.out.println(i);
        }
    }

    public int[] solution(final int[] heights) {
        int[] answer = new int[heights.length];

        Queue<Integer> sendTopQueue = new LinkedList<>(Arrays.asList(IntStream.of(heights).boxed().toArray(Integer[]::new)));
        List<Integer> receiveTopList = new ArrayList<Integer>();

        int answerIndex = 0;
        while (!sendTopQueue.isEmpty()) {
            int peek = (Integer) sendTopQueue.poll();

            int index = searchReceiveTopIndex(receiveTopList, peek);

            receiveTopList.add(peek);

            answer[answerIndex] = index;
            answerIndex++;
        }

//        answer = result.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }

    private int searchReceiveTopIndex(List<Integer> list, int peek ) {
        for(int i=list.size()-1; i>-1; i--) {
            int value = (Integer)list.get(i);

            if(value > peek) {
                return i+1;
            }
        }
        
        return 0;
    }

}