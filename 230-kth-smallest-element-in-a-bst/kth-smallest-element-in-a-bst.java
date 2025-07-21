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
    int counter = 0;
    TreeNode result = null;
    public int kthSmallest(TreeNode root, int k) {
        searchKthSmallest(root, k);
        return result.val;

    }


    public void searchKthSmallest(TreeNode root, int k){
        if(root == null)return;


        searchKthSmallest(root.left, k);
        counter++;
        if(counter == k){
            result = root;
            return;
        }
        searchKthSmallest(root.right, k);
    }
}