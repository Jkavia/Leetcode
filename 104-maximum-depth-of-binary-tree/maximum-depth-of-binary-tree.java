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
    int maxD = 1;
    public int maxDepth(TreeNode root) {
        if(root == null)return 0;

        findDepthHelper(root, 1);
        return maxD;
    }

    public void findDepthHelper(TreeNode root, int depth){
        if(root == null)return;
        maxD = Math.max(maxD, depth);

        findDepthHelper(root.left, depth+1);
        findDepthHelper(root.right, depth+1);
    }
}