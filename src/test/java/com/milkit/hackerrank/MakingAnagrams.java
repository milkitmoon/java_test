package com.milkit.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MakingAnagrams {

    static int makeAnagram(String a, String b) {

//        Set<String> arrSet1 = new HashSet<String>(convertToList(a));
//        Set<String> arrSet2 = new HashSet<String>(convertToList(b));
//        arrSet1.retainAll(arrSet2);


        String anagram = lcs(a, b);

System.out.println(anagram);
//System.out.println(arrSet1.size());

        int removeACount = removeCharCount(a, anagram);
        int removeBCount = removeCharCount(b, anagram);
      
//System.out.println(removeACount);
//System.out.println(removeBCount);  

        return removeACount + removeBCount;
    }

    private static int removeCharCount(String a, String anagram) {

        char[] anagramChar = anagram.toLowerCase().toCharArray();

        StringBuffer buff = new StringBuffer();
        buff.append("[");
        for(char c: anagramChar) {
            buff.append(String.valueOf(c)).append("+");
        }
        buff.append("]*");

        String str = "";  
        str = a.replaceAll(buff.toString(), "");  
System.out.println(str);

        int sameCount = anagramChar.length;
        int dupRemoveCount = (a.length() - (str.length() + sameCount));
//        int removeTotalCount = a.length()-(sameCount + dupRemoveCount);

        int removeTotalCount = str.length();

//System.out.println("dupRemoveCount:"+dupRemoveCount);
//System.out.println("analogramCount:"+(sameCount + dupRemoveCount));
//System.out.println("removeTotalCount:"+removeTotalCount);

        return removeTotalCount;
    }

    private static List<String> convertToList(String str) {
        List<String> tempList = new ArrayList<String>();
        char[] arr = str.toCharArray();
        for (char a : arr) {
            tempList.add(String.valueOf(a));
        }

//System.out.println(tempList);  
        return tempList;
    }

    public static String lcs(String str1, String str2) {

        char[] firstChar = str1.toLowerCase().toCharArray();
        char[] secondChar = str2.toLowerCase().toCharArray();

        Arrays.sort(firstChar);
        Arrays.sort(secondChar);

        String first = new String(firstChar);
        String second = new String(secondChar);

System.out.println(first); 
System.out.println(second); 

        int[][] lengths = new int[first.length()+1][second.length()+1];
        
        for (int i = 0; i < first.length(); i++)
            for (int j = 0; j < second.length(); j++)
                if (first.charAt(i) == second.charAt(j))
                    lengths[i+1][j+1] = lengths[i][j] + 1;
                else
                    lengths[i+1][j+1] =
                        Math.max(lengths[i+1][j], lengths[i][j+1]);
        
        StringBuffer sb = new StringBuffer();
        for (int x = first.length(), y = second.length();
             x != 0 && y != 0; ) {
            if (lengths[x][y] == lengths[x-1][y])
                x--;
            else if (lengths[x][y] == lengths[x][y-1])
                y--;
            else {
                assert first.charAt(x-1) == second.charAt(y-1);
                sb.append(first.charAt(x-1));
                x--;
                y--;
            }
        }
        
        return sb.reverse().toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        System.out.println(String.valueOf(res)+"\n");

        scanner.close();
    }
}