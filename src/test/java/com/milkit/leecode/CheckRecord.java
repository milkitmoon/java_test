package com.milkit.leecode;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import org.junit.*;

public class CheckRecord {

    @Test
    public void checkRecord() {

        String record = "LLLALL";
//        String record = "LLPPPLL";

        boolean result = checkRecord(record);

        System.out.println(result);    
    }

    public boolean checkRecord(String s) {
        boolean checkRecord = true;

        try {
            checkAbsent(s);
            checkLate(s, "L");
        } catch(Exception ex) {
            checkRecord = false;
        }

        return checkRecord;
    }

    private void checkAbsent(String s) throws Exception {
        Pattern pattern = Pattern.compile("([aA])");
        Matcher matcher = pattern.matcher(s);
        int count = 0;
        while (matcher.find()) count++;

System.out.println(count);

        if(count >= 2) {
            throw new Exception();
        }
    }

    private static void checkLate(String string, String spec) throws Exception {
        char current = string.charAt(0);
        int count = 1;
    
        for(int i = 1; i < string.length(); i++){
            char c = string.charAt(i);

//System.out.println(Character.toString(c));
            
            if(current == c && spec.equals(Character.toString(c))) {
                count++;

                if(count >= 3) {
                    throw new Exception();
                }
            } else {
                count = 1;
                current = c;
            }
        }

//System.out.println(count);

      }

}