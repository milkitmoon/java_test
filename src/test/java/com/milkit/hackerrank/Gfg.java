package com.milkit.hackerrank;

import java.util.Arrays;

public class Gfg 
{ 

    public static String lcs(String a, String b) {
        int[][] lengths = new int[a.length()+1][b.length()+1];
        
       
        for (int i = 0; i < a.length(); i++)
            for (int j = 0; j < b.length(); j++)
                if (a.charAt(i) == b.charAt(j))
                    lengths[i+1][j+1] = lengths[i][j] + 1;
                else
                    lengths[i+1][j+1] =
                        Math.max(lengths[i+1][j], lengths[i][j+1]);
        
        StringBuffer sb = new StringBuffer();
        for (int x = a.length(), y = b.length();
             x != 0 && y != 0; ) {
            if (lengths[x][y] == lengths[x-1][y])
                x--;
            else if (lengths[x][y] == lengths[x][y-1])
                y--;
            else {
                assert a.charAt(x-1) == b.charAt(y-1);
                sb.append(a.charAt(x-1));
                x--;
                y--;
            }
        }
        
        return sb.reverse().toString();
    }
  
    public static void main(String args[]) 
    { 
        String str1 = "fcrxzwscanmligyxyvym";
        String str2 = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";

        char[] first = str1.toLowerCase().toCharArray();
        char[] second = str2.toLowerCase().toCharArray();

        Arrays.sort(first);
        Arrays.sort(second);

/*

        String strbuilder = "";
    
        char[] first = str1.toLowerCase().toCharArray();
        char[] second = str2.toLowerCase().toCharArray();

        Arrays.sort(first);
        Arrays.sort(second);
    
        int minLength = Math.min(first.length, second.length);
    
        for (int i = 0; i < minLength; i++) {
            if (first[i] == second[i]) {
                strbuilder += String.valueOf(first[i]);
    
            }
        }
        System.out.println(strbuilder);
*/
        System.out.println(lcs(new String(first), new String(second)));
    } 
} 
