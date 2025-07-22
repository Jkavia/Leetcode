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
        lcaCheck(root, p,q);
        return lca;
    }

    public void lcaCheck(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)return;

        if(root.val > p.val && root.val >q.val){
            lcaCheck(root.left, p,q);
        }else if(root.val < p.val && root.val <q.val){
            lcaCheck(root.right, p,q);
        }else{
            lca = root;
            return;
        }
        
    }
}