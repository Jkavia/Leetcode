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
 //we are going to call the left sub tree and right subtree separately and find their respective max sum
 // the way we will find this max sum is we're gonna call left/right for each node until null
 // and then what ever is a greater value we'll just add that to the root and return root. 
 // And we'll do that to keep traveling upwards. 
 // once we have max sum of both sides well add those two to main root and then return the final value. 
 // Instead of just checking sum of final path we'll add another step to also check the sum of sub paths. 
 // One thing to take care of is that anytime we find a negative value as a sum of left/right we rest that to 0.
class Solution {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSumSide(root);
        return maxSum;
    }

    public int maxSumSide(TreeNode root){
        if(root == null)return 0;

        int left = maxSumSide(root.left);
        int right = maxSumSide(root.right);

        int leftSum = left<0?0:left;
        int rightSum = right<0?0:right;

        maxSum = Math.max(maxSum, root.val+leftSum+rightSum);

        return Math.max(leftSum, rightSum)+root.val;
    }
}