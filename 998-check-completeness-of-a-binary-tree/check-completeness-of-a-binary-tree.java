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

 //To verify completeness we do a bfs using que, and check if at any point while parsing que there is a null
 // that means its a last value and there should be no kids either, if any of these conditions fails we know tree 
 // isnt binary

class Solution {
    public boolean isCompleteTree(TreeNode root) {
        boolean isLastLayer = false;

        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        while(!que.isEmpty()){
            int size = que.size();
            for(int i =0;i<size;i++){
                TreeNode node = que.poll();
                if(node == null){
                    isLastLayer = true;
                }else{
                if(isLastLayer)return false;
                TreeNode left = node.left;
                TreeNode right = node.right;
                que.add(left);
                que.add(right);
                }
            }
        }

        return true;

        
    }
}