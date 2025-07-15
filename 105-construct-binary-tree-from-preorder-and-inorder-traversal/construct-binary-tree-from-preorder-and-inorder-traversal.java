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
    int preIndex =0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        for(int val: inorder){
            map.put(val, idx++);
        }

        return buildTreeHelper(preorder, map, 0, inorder.length-1);
    }

    public TreeNode buildTreeHelper(int[] preorder, Map<Integer, Integer> map, int l, int r){
        if(l>r)return null;

        int curr = preorder[preIndex++];
        TreeNode root = new TreeNode(curr);
        int rootIndex = map.get(curr);

        root.left = buildTreeHelper(preorder, map, l, rootIndex-1);
        root.right = buildTreeHelper(preorder, map, rootIndex+1, r);

        return root;
    }
}