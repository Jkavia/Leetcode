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
    public int maxDepth(TreeNode root) {
        int depth = 0;

        return helperDepth(root, depth);
    }

    private int helperDepth(TreeNode root, int depth){
        if(root == null){
            return depth;
        }

        int left = helperDepth(root.left, depth+1);
        int right = helperDepth(root.right, depth+1);

        return Math.max(left, right);

    }
}