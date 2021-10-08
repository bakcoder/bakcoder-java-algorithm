package leetcode;

import leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaximumDepthofBinaryTree {
    public static void main(String[] args) {
        MaximumDepthofBinaryTree mdbt = new MaximumDepthofBinaryTree();
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(mdbt.solution(root));
    }

    public int solution(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0;

        if(root == null) return 0;
        else depth++;

        if(root.left != null) queue.offer(root.left);
        if(root.right != null) queue.offer(root.right);

        if(!queue.isEmpty()) depth++;

        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            for(int i=0 ; i<queueSize ; i++) {
                TreeNode node = queue.poll();
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }

            if(!queue.isEmpty()) depth++;
        }
        return depth;
    }

    public int otherSolution(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1+Math.max(otherSolution(root.left),otherSolution(root.right));
    }
}


// Given the root of a binary tree, return its maximum depth.
// A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

//Input: root = [3,9,20,null,null,15,7]
//Output: 3

//Input: root = [1,null,2]
//Output: 2

// * constraints
//    The number of nodes in the tree is in the range [0, 104].
//    -100 <= Node.val <= 100