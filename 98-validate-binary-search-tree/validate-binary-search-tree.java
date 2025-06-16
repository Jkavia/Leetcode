/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        
        return isValidBSTX(root, -1*Double.MAX_VALUE, Double.MAX_VALUE);
    }

    public boolean isValidBSTX(TreeNode root, double leftMax, double rightMax){
        if(root == null){
            return true;
        }
        if(root.left!=null && (root.left.val >= root.val || root.left.val<=leftMax)){
            return false;
        }
        if(root.right!=null && (root.right.val <= root.val || root.right.val>=rightMax)){
            return false;
        }

        return isValidBSTX(root.left,leftMax, root.val ) && isValidBSTX(root.right,root.val,rightMax);
    }
}