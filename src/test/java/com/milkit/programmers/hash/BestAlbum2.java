package com.milkit.programmers.hash;

import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.*;
import static java.util.Comparator.comparingInt;

import org.junit.Test;

public class BestAlbum2 {

    public class Music implements Comparable<Music>{

        private int id;
        private String genre;
        private int played;

    
        public Music(int id, String genre, int played) {
            this.id = id;
            this.genre = genre; 
            this.played = played;
        }
    
        @Override
        public int compareTo(Music other) {
            if(this.played == other.played) { 
                return this.id - other.id;
            } else {
                return other.played - this.played;
            }
        }
    
        public String getGenre() {
            return genre;
        }
      }

    @Test
    public void bestAlbum() {

        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500}; 

        int[] retult = solution(genres, plays);
        for(int i:retult) {
            System.out.println(i);
        }

    }


    public int[] solution(String[] genres, int[] plays) {
        return IntStream.range(0, genres.length)
        .mapToObj(i -> new Music(i, genres[i], plays[i]))
        .collect(Collectors.groupingBy(Music::getGenre))
        .entrySet().stream()
        .sorted((a, b) -> sum(b.getValue()) - sum(a.getValue()))
        .flatMap(x->x.getValue().stream().sorted().limit(2))
        .mapToInt(x->x.id).toArray();
    }

    private int sum(List<Music> value) {
        int answer = 0;
        for (Music music : value) {
          answer+=music.played;
        }
        return answer;
    }

}

