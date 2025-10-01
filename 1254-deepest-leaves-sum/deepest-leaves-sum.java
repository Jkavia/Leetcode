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
    int maxDepth =0;

    public int deepestLeavesSum(TreeNode root) {
        findMaxDepth(root, 0);

        return getmaxsum(root, 0);
    }

    public void findMaxDepth(TreeNode root, int depth){
        if(root == null){
            maxDepth = Math.max(maxDepth, depth-1);
            return;
        }

        findMaxDepth(root.left, depth+1);
        findMaxDepth(root.right, depth+1);
    }

    public int getmaxsum(TreeNode root, int depth){
        if(root == null){
            return 0;
        }
        if(depth == maxDepth)return root.val;

        return getmaxsum(root.left, depth+1)+getmaxsum(root.right, depth+1);
    }

}