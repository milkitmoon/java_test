package com.milkit.programmers.dfsbfs;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Dfs3 {

    int count = 0;

    @Test
    public void dfs3() {
        // final int[] height = { 6, 9, 5, 7, 4 };
        final int[] numbers = {1, 1, 1, 1, 1};
        final int target = 3;

        final int result = solution(numbers, target);
        System.out.println(result);

//System.out.println("count:"+count);
    }

    public int solution(int[] numbers, int target) {
        Queue<Node> numberQueue = new LinkedList<Node>();
        numberQueue.offer(new Node(0, 0));

        return search(numbers, target, numberQueue);
    }



    private int search(int[] numbers, int target, Queue<Node> numberQueue) {
        int answer = 0;

        while(numberQueue.peek()!=null) {
            Node node = numberQueue.poll();

            int level = node.getLevel();
            int value = node.getValue();

            if(level == numbers.length){
                if(value == target) {
                    answer++;
                }
            }else {
                numberQueue.offer(new Node(level+1, value + numbers[level]));
                numberQueue.offer(new Node(level+1, value - numbers[level]));
            }
//System.out.println(numberQueue);
        }

        return answer;
    }

    class Node {
        private int level;
        private int value;

        public Node(int level, int value) {
            this.level = level;
            this.value = value;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String toString() {
            StringBuffer buff = new StringBuffer();
            buff.append("[level]:").append(level);
            buff.append("[value]:").append(value).append("\n");

            return buff.toString();
        }
    }

}