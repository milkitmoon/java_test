package com.milkit.leecode;

import org.junit.Test;

public class ReverseList {

    @Test
    public void reverseString() {

        ListNode node = reverseList(new ListNode(1));
        System.out.println(node);
    }

    public ListNode reverseList(ListNode head) {
        return reverseNoe(head, null);
    }

    private ListNode reverseNoe(ListNode node, ListNode prev) {

        if(node != null) {
            ListNode parent = node.next;

            node.next = prev;
            prev = node;

            node = parent;

            return reverseNoe(node, prev);
        } else {
            return prev;
        }

    }

    
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

}
