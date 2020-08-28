package com.milkit;

import org.junit.*;


public class CodeTest6 {

    @Test
    public void linkedListTest() {

        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

System.out.println(head);

        ListNode revList = reverseList(head);

System.out.println(revList);
    }

    public ListNode reverseList(ListNode head) {
        return head;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public String toString() {
        StringBuffer strBuff = new StringBuffer();
        strBuff.append(Integer.toString(val));
        if(next != null) {
            strBuff.append("->").append(next.toString());
        }

        return strBuff.toString();
    }
}