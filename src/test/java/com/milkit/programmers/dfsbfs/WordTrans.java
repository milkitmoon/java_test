package com.milkit.programmers.dfsbfs;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WordTrans {

    @Test
    public void wordTrans() {

        final String begin = "hit";
        final String target = "cog";
        final String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
//        final String[] words = {"hot", "dot", "dog", "lot", "log"};

        final int result = solution(begin, target, words);
        System.out.println(result);

//System.out.println("count:"+count);
    }

    public int solution(String begin, String target, String[] words) {
        if(Arrays.stream(words).anyMatch(target::equals)) {
            boolean[] visited = new boolean[words.length];
            Stack<Node> stack = new Stack<>();
            stack.push(new Node(begin, 1));
                
            return transCount(stack, visited, target, words);
        } else {
            return 0;
        }
    }

    private int transCount(Stack<Node> stack, boolean[] visited, String target, String[] words) {
        
        if(!stack.empty()) {
            Node current = stack.pop();

System.out.println(current);            

            if(current.level >= words.length) {
                return 0;
            }

           
            if(isChangable(current.word, target)) {
                return current.level;
            }

/*
            if(current.word.equals(target)) {
                return current.level;
            }
*/
            for(int i=0; i<words.length; i++) {
                if( isChangable(current.word, words[i]) && !visited[i] ) {
                    stack.push( new Node(words[i], current.level+1) );
                    visited[i] = true;

                    return transCount(stack, visited, target, words);
                }
            }
        }

        return 0;
    }

    public boolean isChangable(String str1, String str2) {
        int count = 0;
        for(int i=0; i<str1.length(); i++) {
            if(str1.charAt(i) != str2.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }

    class Node {
        String word;
        int level;

        public Node(String str, int lev) {
            this.word = str;
            this.level = lev;
        }

        public String toString() {
            StringBuffer buff = new StringBuffer();
            buff.append("[level]:").append(level);
            buff.append("[word]:").append(word);

            return buff.toString();
        }
    }

}