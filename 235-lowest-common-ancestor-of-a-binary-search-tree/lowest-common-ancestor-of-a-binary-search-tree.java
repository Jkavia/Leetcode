/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode lca = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lcaHelper(root, p, q);
        return lca;
    }

    public void lcaHelper(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)return;

        if(p.val < root.val && q.val < root.val){
            lcaHelper(root.left, p, q);
        }else if (p.val > root.val && q.val > root.val){
            lcaHelper(root.right, p, q);
        }else{
            lca = root;
            return;
        }
    }
}