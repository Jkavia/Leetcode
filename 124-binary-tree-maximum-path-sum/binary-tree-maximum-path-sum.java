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
        pathSum(root);

        return maxSum;
    }

    public int pathSum(TreeNode root){
        if(root == null)return 0;

        int rootVal = root.val;

        int left = pathSum(root.left);
        int right = pathSum(root.right);

        int adjustedLeft = (left<0)?0:left;
        int adjustedRight = (right<0)?0:right;
        maxSum = Math.max(maxSum, rootVal+adjustedLeft+adjustedRight);
        return rootVal+Math.max(adjustedLeft, adjustedRight);
    }
}

//here we need to maintain a class level variable that tracks max at each node level
// we do the dfs on both left and right side and on its way back we add the node values 
// but if a left or right node value is negative then we consider it as good as none so we default it to 0 
// and then at each root node level we just add the max of left or right to root value and send it. 
// what this is doing is if at that root it was a max sum it would be registed in class level variable 
// and it it wasnt then the best we can do from that level is to send back the max sum from either of the paths or none if negative. 