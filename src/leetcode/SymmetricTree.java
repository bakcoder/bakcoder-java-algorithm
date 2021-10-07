package leetcode;

import leetcode.util.TreeNode;

import java.util.Stack;

public class SymmetricTree {
    public static void main(String[] args) {
        SymmetricTree st = new SymmetricTree();
        TreeNode root = new TreeNode(1, new TreeNode(2,new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)));

        System.out.println(st.solution2(root));
    }

    public boolean solution1(TreeNode root) {
        return root == null || isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left == null || right == null) return left == right;

        if(left.val != right.val) return false;

        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    public boolean solution2(TreeNode root) {

        if(root == null) return true;

        Stack<TreeNode> stack = new Stack<TreeNode>();

        if(root.left != null) {
            if(root.right == null) return false;

            stack.push(root.left);
            stack.push(root.right);
        }else {
            if(root.right != null) return false;
        }

        while(!stack.isEmpty()) {
            if(stack.size() % 2 !=0) return false;
            TreeNode left = stack.pop();
            TreeNode right = stack.pop();

            if(left.val != right.val) return false;

            if(left.left != null) {
                if(right.right == null) return false;
                stack.push(left.left);
                stack.push(right.right);
            }else {
                if(right.right != null) return false;
            }

            if(left.right != null) {
                if(right.left == null) return false;
                stack.push(left.right);
                stack.push(right.left);
            }else {
                if(right.left != null) return false;
            }
        }

        return true;
    }

}

// Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

//Input: root = [1,2,2,3,4,4,3]
//Output: true

//* constraints
//The number of nodes in the tree is in the range [1, 1000].
//-100 <= Node.val <= 100