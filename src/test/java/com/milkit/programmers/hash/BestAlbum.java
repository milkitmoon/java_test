package com.milkit.programmers.hash;

import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.*;
import static java.util.Comparator.comparingInt;

import org.junit.Test;

public class BestAlbum {

    @Test
    public void bestAlbum() {

        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500}; 

        System.out.println(solution(genres, plays));

    }


    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        Map<String, List<Integer>> result = IntStream.range(0, genres.length)
            .boxed()
//            .sorted((a, b) -> sum(b.getValue()) - sum(a.getValue()))
            .collect(
                Collectors.groupingBy(
                    i -> genres[i],
                    Collectors.toList()
//                    Collectors.summingInt(i -> plays[i])
                )
            )
            ;


        System.out.println(result);


        return answer;
    }

    private int sum(List<Integer> value) {
        int answer = 0;
        for (Integer music : value) {
          answer+=music;
        }
        return answer;
    }

}

