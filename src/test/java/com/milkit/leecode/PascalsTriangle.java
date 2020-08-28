package com.milkit.leecode;

import java.util.*;
import org.junit.*;

public class PascalsTriangle {

    @Test
    public void pascalsTriangle() {

        List<List<Integer>> result = generate(5);

System.out.println(result);        
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>(numRows);

        generateInnerList(numRows, 0, triangle);

        return triangle;
    }

    private void generateInnerList(int numRows, int curRows, List<List<Integer>> triangle) {
        if(curRows >= numRows) {
            return;
        }

        List<Integer> innerList = new ArrayList<Integer>();
        try {
            List<Integer> upperList = triangle.get(curRows-1);
            for(int i=0; i<=curRows; i++) {
                int leftVal = getValue(upperList, i-1);
                int rightVal = getValue(upperList, i);

//System.out.println("[curRows]   leftVal:"+leftVal+"     rightVal:"+rightVal);

                innerList.add( leftVal+rightVal );
            }
        } catch(java.lang.IndexOutOfBoundsException iex) {
            innerList.add(1);
        }

//System.out.println("[innerList]:"+innerList);

        triangle.add(innerList);

        generateInnerList(numRows, ++curRows, triangle);
    }

    private int getValue(List<Integer> upperList, int curRows) {
        int value = 0;
        try {
            value = upperList.get(curRows);
        } catch(Exception ex) {}

        return value;
    }

}