package syhan.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(4);

        node4.next = node5;
        node5.next = node6;

        Problem2 problem2 = new Problem2();
        ListNode node = problem2.addTwoNumbers(node1, node4);
        problem2.prettyPrint(node);

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> result = new ArrayList<>();

        List<Integer> list1 = toList(l1, new ArrayList<>());
        List<Integer> list2 = toList(l2, new ArrayList<>());

        if (list1.size() < list2.size()) {
            List<Integer> temp = list2;
            list2 = list1;
            list1 = temp;
        }

        boolean carry = false;
        for(int i = 0; i < list1.size(); i++) {
            Integer v1 = list1.get(i);
            Integer v2 = (i <= list2.size() - 1) ? list2.get(i) : 0;

            Integer sum = v1 + v2 + (carry ? 1 : 0);
            if (sum > 9) {
                sum = sum - 10;
                carry = true;
            } else {
                carry = false;
            }

            result.add(sum);
        }

        if (carry) {
            result.add(1);
        }

        return toNode(result, new ListNode(0));
    }

    private List<Integer> toList(ListNode node, List<Integer> acc) {
        if (node == null) {
            return acc;
        }

        acc.add(node.val);
        return toList(node.next, acc);
    }

    private ListNode toNode(List<Integer> list, ListNode acc) {
        if (list.isEmpty()) {
            return null;
        }

        Integer val = list.get(0);
        List<Integer> left = list.subList(1, list.size());

        acc.val = val;
        acc.next = toNode(left, new ListNode(0));

        return acc;
    }

    private void prettyPrint(ListNode node) {
        if (node != null) {
            System.out.println(node.val);
            prettyPrint(node.next);
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }


}
