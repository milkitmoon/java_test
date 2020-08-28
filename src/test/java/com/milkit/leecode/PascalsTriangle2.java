package com.milkit.leecode;

import java.util.*;
import org.junit.*;

public class PascalsTriangle2 {

    @Test
    public void pascalsTriangle2() {

        List<Integer> result = getRow(3);

System.out.println(result);        
    }

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> triangle = generateTriangle(rowIndex+1);
        return triangle.get(rowIndex);
    }

    public List<List<Integer>> generateTriangle(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>(numRows);

        generateInnerList(numRows, 0, triangle);

        return triangle;
    }

    private void generateInnerList(int numRows, int curRows, List<List<Integer>> triangle) {
        if(curRows >= numRows) {
            return;
        }

        List<Integer> innerList = new ArrayList<Integer>();
        if(curRows == 0) {
            innerList.add(1);
        } else {

            List<Integer> upperList = triangle.get(curRows-1);
            for(int i=0; i<=curRows; i++) {
                int leftVal = getValue(upperList, i-1);
                int rightVal = getValue(upperList, i);

//System.out.println("[curRows]   leftVal:"+leftVal+"     rightVal:"+rightVal);

                innerList.add( leftVal+rightVal );
            }

       }

//System.out.println("[innerList]:"+innerList);

        triangle.add(innerList);

        generateInnerList(numRows, ++curRows, triangle);
    }

    private int getValue(List<Integer> upperList, int curRows) {
        int value = 0;
        if(curRows >= 0 && upperList.size() > curRows) {
            value = upperList.get(curRows); 
        }

        return value;
    }
    
}