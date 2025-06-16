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
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> retlist = new ArrayList<>();
        if(root == null) return retlist;

        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        retlist.add(Arrays.asList(root.val));

        while(!que.isEmpty()){
            Queue<TreeNode> tempque = new LinkedList<>();

            while(!que.isEmpty()){
                TreeNode temproot = que.poll();
                if(temproot.left != null){
                    tempque.add(temproot.left);
                }
                if(temproot.right != null){
                    tempque.add(temproot.right);
                }
            }

            que = new LinkedList<>(tempque);
            List<Integer> temp = new ArrayList<>();
            while(!tempque.isEmpty()){
                TreeNode temproot = tempque.poll();
                temp.add(temproot.val);
            }

            if(!temp.isEmpty()){
                retlist.add(temp);
            }
        }

        return retlist;


        
    }
}