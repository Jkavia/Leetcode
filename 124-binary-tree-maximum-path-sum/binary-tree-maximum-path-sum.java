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
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathHelper(root);

        return maxSum;
    }

    public int maxPathHelper(TreeNode root){
        if(root == null)return 0;

        int left = maxPathHelper(root.left);
        int right = maxPathHelper(root.right);
        int leftVal = left < 0? 0: left;
        int rightVal = right < 0? 0: right;

        maxSum = Math.max(maxSum, leftVal+rightVal+root.val);

        return Math.max(leftVal+root.val, rightVal+root.val);

    }
}