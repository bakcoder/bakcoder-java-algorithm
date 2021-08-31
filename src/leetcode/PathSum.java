package leetcode;

import leetcode.util.TreeNode;

public class PathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        PathSum pathSum = new PathSum();
        System.out.println(pathSum.mysolution(root, 5));
    }

    public boolean mysolution(TreeNode root, int targetSum) {
        boolean result = false;
        if(root == null) {
            return false;
        }else {
            if(root.left != null) {
                result |= mysolution(root.left, targetSum - root.val);
            }

            if(root.right != null) {
                result |= mysolution(root.right, targetSum - root.val);
            }

            if(root.val == targetSum && root.right == null && root.left == null) {
                return true;
            }
        }
        return result;
    }

    public boolean otherSolution(TreeNode root, int sum) {
        if(root == null) return false;

        if(root.left == null && root.right == null && sum - root.val == 0) return true;

        return otherSolution(root.left, sum - root.val) || otherSolution(root.right, sum - root.val);
    }
}
