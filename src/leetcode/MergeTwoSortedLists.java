package leetcode;

import leetcode.util.ListNode;

import java.util.Stack;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        MergeTwoSortedLists mtsl = new MergeTwoSortedLists();

        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));


        ListNode result = mtsl.otherSolution(l1, l2);

        StringBuilder sb = new StringBuilder();

        while(true) {
            if(result == null) break;
            sb.append(result.val);
            result = result.next;
        }

        System.out.println(sb.toString());
    }

    public ListNode mySolution(ListNode l1, ListNode l2) {
        ListNode result = null;

        boolean flag = true;
        Stack<Integer> stack = new Stack<>();
        while(flag) {
            if(l1 == null && l2 == null) flag = !flag;
            else if(l1 == null || (l2 !=null && l1.val > l2.val)) {
                stack.push(l2.val);
                l2 = l2.next;
            } else if(l2 == null || l1.val <= l2.val) {
                stack.push(l1.val);
                l1 = l1.next;
            }
        }

        while(!stack.isEmpty()) {
            result = new ListNode(stack.pop(), result);
        }

        return result;
    }

    // using recursion
    public ListNode otherSolution(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;

        if(l2 == null) return l1;

        if(l1.val < l2.val) {
            l1.next = otherSolution(l1.next, l2);
            return l1;
        }else {
            l2.next = otherSolution(l2.next, l1);
            return l2;
        }
    }
}


/*
    Merge two sorted linked lists and return it as a sorted list.
    The list should be made by splicing together the nodes of the first two lists.

    ex)
    Input: l1 = [1,2,4], l2 = [1,3,4]
    Output: [1,1,2,3,4,4]

    1 1

    Input: l1 = [], l2 = []
    Output: []

    Input: l1 = [], l2 = [0]
    Output: [0]

    The number of nodes in both lists is in the range [0, 50].
    -100 <= Node.val <= 100
    Both l1 and l2 are sorted in non-decreasing order.
*/