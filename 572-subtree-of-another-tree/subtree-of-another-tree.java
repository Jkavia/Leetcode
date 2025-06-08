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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null){
            return false;
        }
        if(root.val == subRoot.val){
            boolean compare = compareTrees(root, subRoot);
            if (compare){
                return true;
            }
        }

         boolean left = isSubtree(root.left, subRoot);  
         boolean right = isSubtree(root.right, subRoot);
        return left||right;
    }

    public boolean compareTrees(TreeNode root, TreeNode subRoot){
        if(subRoot == null || root == null){
            if(subRoot == null && root == null){
            return true;
            }else{
                return false;
            }
        }

        if(root.val != subRoot.val){
            return false;
        }
        boolean left = compareTrees(root.left, subRoot.left);
        boolean right = compareTrees(root.right, subRoot.right);

        return left && right;
    }

}