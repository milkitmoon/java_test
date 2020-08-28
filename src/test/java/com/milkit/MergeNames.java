package com.milkit;

import java.util.*;

public class MergeNames {
    
    public static String[] uniqueNames(String[] names1, String[] names2) {
        Set<String> nameSet = new HashSet<String>();

        if(names1 != null) {
            nameSet.addAll(Arrays.asList(names1));
        }
        if(names2 != null) {
            nameSet.addAll(Arrays.asList(names2));
        }

        return nameSet.toArray(new String[]{});
    }
    
    public static void main(String[] args) {
        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2)));
    }
}