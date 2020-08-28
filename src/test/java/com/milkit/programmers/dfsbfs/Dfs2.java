package com.milkit.programmers.dfsbfs;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Dfs2 {

    @Test
    public void dfs() {
 
        final int[] numbers = {1, 1, 1, 1, 1};
        final int target = 3;

        final int result = solution(numbers, target);
        System.out.println(result);
    }

    public int solution(int[] numbers, int target) {
        int answer = 0;
        Node node = new Node(0);  // 초기 값 0부터 시작

        for(int i=0; i<numbers.length; i++) {   
            node.setNode(node, numbers[i]);
        }

//System.out.println(node);        

        answer = node.countValue(node, target);

        return answer;
    }

 class Node {
     private int value;
     private Node rightNode ;   //+ 노드
     private Node leftNode ;    //- 노드 

     public Node() {
         value=0;
     }

     public Node(int value) {
         this.value =value;
         this.rightNode = null;
         this.leftNode = null;
     }
     /*
      * 다음 depth의 노드를 셋팅 한다. 
      * 현재 노드가 leaf 노드면 다음 노드를 셋팅 한다. 
      */
     public void setNode(Node node, int val) {

System.out.println(node+"   [val]:"+val);         

         if(!node.isTerminal()) {
             setNode(node.leftNode, val);
             setNode(node.rightNode, val);
         } else {
             node.rightNode = new Node(node.getValue() + val);
             node.leftNode = new Node(node.getValue() - val);
         }
    }

    public String toString() {
        StringBuffer buff = new StringBuffer();
        buff.append("[value]:"+value);
        buff.append("\n");
        if(!this.isTerminal()) {
            buff.append("[leftNode]\n");
            buff.append(leftNode);
            buff.append("[rightNode]\n");
            buff.append(rightNode);
        }

        return buff.toString();
    }

    public boolean isTerminal() {
        return this.rightNode==null && this.leftNode==null ? true : false;
    }

    public int countValue(Node node,int value) {

        if(!node.isTerminal()) {
            return countValue(node.leftNode,value) +countValue(node.rightNode,value);
        } else {
            if(node.getValue() == value) {
                return 1;
            }
        }

        return 0;
    }

    public void searchNode(Node node) {

    }
    public int getValue() {
         return this.value;
    }

 }

}