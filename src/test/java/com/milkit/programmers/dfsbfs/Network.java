package com.milkit.programmers.dfsbfs;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Network {

    @Test
    public void network() {

        final int n = 3;
        final int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
//        final int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};

        final int result = solution(n, computers);
        System.out.println(result);

//System.out.println("count:"+count);
    }

    public int solution(int n, int[][] computers) {
        int cnt=0;
        boolean[] check = new boolean[n];

        for(int i=0; i<check.length; i++) {
            if(check[i]==false) {
                dfs(computers, check, i);
                cnt++;
            }
        }
        return cnt;
    }
    public void dfs(int[][]computers, boolean[]check, int i) {
        check[i]=true;

        for(int j=0; j<computers[0].length; j++) {
            if(computers[i][j]==1 && check[j]==false) {
                dfs(computers, check, j);
            }
        }
    }

}