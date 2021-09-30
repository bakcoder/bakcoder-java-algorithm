package leetcode;

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        BinaryTreeInorderTraversal btit = new BinaryTreeInorderTraversal();
//        TreeNode treeNode = new TreeNode(1, null , new TreeNode(2, new TreeNode(3), null));
//        TreeNode treeNode = new TreeNode(1,new TreeNode(2), null);
        TreeNode treeNode = new TreeNode(2, new TreeNode(3,  new TreeNode(1), null), null);
        List<Integer> result = btit.mySolution(treeNode);

        for(int i=0 ; i<result.size() ; i++) {
            System.out.println(result.get(i));
        }
    }

    List<Integer> resultList = new ArrayList<>();

    public List<Integer> mySolution(TreeNode root) {

        if(root == null)
            return resultList;
        else {
            if(root.left != null)
                mySolution(root.left);
            resultList.add(root.val);
            if(root.right != null)
                mySolution(root.right);
        }

        return resultList;
    }

    public List<Integer> otherSolution(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;

        while(cur != null || !stack.empty()){
            while(cur!=null){
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }

        return list;
    }
}


//Given the root of a binary tree, return the inorder traversal of its nodes' values.

//Input: root = [1,null,2,3]
//Output: [1,3,2]

//Input: root = [1]
//Output: [1]

//Input: root = [1,null,2]
//Output: [1,2]

// * constraints
//  The number of nodes in the tree is in the range [0, 100].
//        -100 <= Node.val <= 100