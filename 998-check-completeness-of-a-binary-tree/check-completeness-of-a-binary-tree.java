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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        boolean firstNullFound = false;
        while (!que.isEmpty()) {
            int size = que.size();
            int nonnullcount =0;
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                if (node == null) {
                    firstNullFound = true;
                    continue;
                }
                if (firstNullFound && node != null) {
                    return false;
                }
                if(node.left !=null){
                    nonnullcount++;
                }
                
                if(node.right !=null){
                    nonnullcount++;
                }
                que.add(node.left);
                que.add(node.right);
            }
            //that means there was null on second last level
            if(firstNullFound && nonnullcount>0)return false;
            firstNullFound = false;
        }

        return true;
    }
}