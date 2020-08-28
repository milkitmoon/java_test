package com.milkit.programmers.dfsbfs;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WordTrans2 {

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
        HashMap<String, Boolean> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(new Node(begin, -1));

        return bfs(begin, target, words, visited, queue);
    }

    public int bfs(String begin, String target, String[] words, Map<String, Boolean> visited, Queue<Node> queue) {

        if(!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0; i<size; i++){
                Node node = queue.poll();

//System.out.println(node);

                node.level++;

                visited.put(node.word, true);

                if(node.word.equals(target)) {
                    return node.level;
                }

                for(String candidate: nextWord(node.word, words)) {

//System.out.println(visited.getOrDefault(candidate, false));

                    if(visited.getOrDefault(candidate, false) == false) {
                        queue.add(new Node(candidate, node.level));
                    }
                }
            }

            return bfs(begin, target, words, visited, queue);
        }

        return 0;
    }

    public String[] nextWord(String key, String[] words) {
        ArrayList<String> ret = new ArrayList<String>();
        for(String word : words) {
            int sum = 0;
            for(int i=0; i<word.length(); i++){
                if(word.charAt(i) != key.charAt(i)){
                    sum += 1;
                }
            }
            if(sum == 1){
                ret.add(word);
            }
        }

        return ret.toArray(new String[ret.size()]);
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