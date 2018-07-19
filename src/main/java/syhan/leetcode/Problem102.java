package syhan.leetcode;


import java.util.ArrayList;
import java.util.List;

public class Problem102 {
    public static void main(String[] args) {
        Problem102 solution = new Problem102();

        TreeNode root = new TreeNode(3);
        TreeNode l2 = new TreeNode(9);
        TreeNode r2 = new TreeNode(20);
        TreeNode l3 = new TreeNode(15);
        TreeNode r3 = new TreeNode(7);

        root.left = l2;
        root.right = r2;

        r2.left = l3;
        r2.right = r3;

        List<List<Integer>> lists = solution.levelOrder(root);

        System.out.println(lists);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        helper(result, root, 0);
        return result;
    }

    public void helper(List<List<Integer>> acc, TreeNode node, int height) {
        if (node == null) {
            return;
        }

        if (height == acc.size()) {
            acc.add(new ArrayList<>());
        }

        acc.get(height).add(node.val);

        helper(acc, node.left, height + 1);
        helper(acc, node.right, height + 1);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

