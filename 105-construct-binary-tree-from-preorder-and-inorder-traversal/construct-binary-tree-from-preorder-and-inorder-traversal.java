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
    int preIndex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        int idx=0;
        for(int num:inorder){
            map.put(num,idx++);
        }
        return generateTree(preorder, map, 0, inorder.length-1);
    }

    public TreeNode generateTree(int[] preorder, Map<Integer, Integer> map, int l, int r){
        if(l>r)return null;
        int curr = preorder[preIndex++];
        TreeNode root = new TreeNode(curr);

        int indexOfRoot = map.get(curr);

        root.left = generateTree(preorder,map, l, indexOfRoot-1);
        root.right = generateTree(preorder,map, indexOfRoot+1, r);
        
        return root;
    }
}

// left-root-right 
// root-left-right 
