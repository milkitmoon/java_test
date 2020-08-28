
package com.milkit.leecode;

import org.junit.Assert;
import org.junit.Test;

public class ReverseString {


    @Test
    public void reverseString() {
//        char a[] = {'h','e','l','l','o'};
        char a[] = {'H','a','n','n','a','h'};

        reverseString(a);

        System.out.println(a);    
    }

    public void reverseString(char[] s) {
        int left  = 0;             // 맨 좌측 요소의 첨자
        int right = s.length - 1;

        reverseRecur(s, left, right);
    }
    
    private void reverseRecur(char[] s, int left, int right) {
        if(s == null || left >= right ) {
            return;
        }

        char temp = s[left];
        s[left]  = s[right];     // 좌우 요소 교환
        s[right] = temp;

        left++; right--; 

//        System.out.print(s[left]+" "+s[right]);
//        System.out.println();

        reverseRecur(s, left, right);
    }
}