package org.leetcode.medium;

public class LinkedListSumOfNodes {
    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode out = dummyNode;
        int extra = 0;
        while (l1 != null || l2 != null || extra != 0) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val )+ extra;
            out.next = new ListNode(sum % 10);
            extra = sum / 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            out = out.next;
        }
        return dummyNode.next;
    }



    public static void main(String[] args) {
        int number = 3;

        // Get the units (ones place) of the number
        int units = number % 10;

        System.out.println("Units of the number " + number + ": " + units);
    }
}

