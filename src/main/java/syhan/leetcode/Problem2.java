package syhan.leetcode;

/**
 * https://leetcode.com/problems/add-two-numbers/description/
 */
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
        boolean carry = false;
        ListNode node = new ListNode(0);
        ListNode curr = node;
        ListNode l = l1;
        ListNode r = l2;
        while (l != null || r != null) {
            int v1 = l != null ? l.val : 0;
            int v2 = r != null ? r.val : 0;

            int sum = v1 + v2 + (carry ? 1 : 0);

            if (sum > 9) {
                sum = sum - 10;
                carry = true;
            } else {
                carry = false;
            }

            curr.next = new ListNode(sum);
            curr = curr.next;

            if (l != null) l = l.next;
            if (r != null) r = r.next;

        }
        if (carry) {
            curr.next = new ListNode(1);
        }

        return node.next;
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
