package com.milkit;

import java.util.stream.Stream;

public class MergeNames2 {
    
    public static String[] uniqueNames(String[] names1, String[] names2) {

        String[] uniqueNames = new String[]{};

        Stream<String> s1 = Stream.of(names1);
        Stream<String> s2 = Stream.of(names2);

        Stream<String> s = Stream.concat(s1, s2).distinct();
        uniqueNames = s.toArray(String[]::new);

 //       String[] uniqueNames2 = s.toArray(String[]::new);

//System.out.println("aaa:"+String.join(", ", uniqueNames2)); 

        return uniqueNames;
    }
    
    public static void main(String[] args) {
        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2)));
    }
}