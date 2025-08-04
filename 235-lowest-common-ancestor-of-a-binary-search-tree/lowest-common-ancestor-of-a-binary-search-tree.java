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
    TreeNode parent = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lcaHelper(root, p, q);
        return parent;
    }

    public void lcaHelper(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)return;

        if(p.val < root.val && q.val < root.val){
            lcaHelper(root.left, p, q);
        }else if(p.val > root.val && q.val > root.val){
            lcaHelper(root.right, p, q);
        }else{
            parent = root;
        }
    }
}

// if both nodes are smaller than root then we move left 
// if both nodes are greater than root then we move to the right 
// now if one is greater than equal and one is less than equal 
// then that means its the common ancestor !! 