package com.milkit.hackerrank;

import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class AlternatingCharacters {
    
    static int alternatingCharacters(String s) {

        List<Character> list = s.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        

        int removeCount = getRemoveCount(list);

        return removeCount;
    }

    private static int getRemoveCount(List<Character> list) {
        int charType = getCharType(list);
        
        int removeCount = 0;
        char nextVal = 'A';

        if(charType == 1) {
            nextVal = 'B';
        }

        for(int i=1; i<list.size(); i++) {
            char currVal = list.get(i);
            if(currVal == nextVal) {
                nextVal = getNextVal(currVal);
            } else {
                removeCount++;
            }
        }

        return removeCount;
    }

    private static char getNextVal(char charVal) {
        if(charVal == 'A') {
            return 'B';
        } else {
            return 'A';
        }
    }

    private static int getCharType(List<Character> list) {
        int charType = 1;
        if(list.get(0).charValue() == 'B') {
            charType = 2;
        }
        return charType;
    }

    static int alternatingCharacters2(String s) {
        int counter=0;
        char[] s1 = s.toCharArray();

        for(int i=0;i<s1.length-1;i++) {
        
            if(s1[i]==s1[i+1]) {
                counter++;
            }

        }

        return counter;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = alternatingCharacters(s);

            System.out.println(String.valueOf(result)+"\n");
        }

        scanner.close();
    }
}