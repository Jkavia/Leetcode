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
        List<Integer> list = Arrays.stream(inorder).boxed().collect(Collectors.toList());
        return generateTree(preorder, list, 0, list.size()-1);
    }

    public TreeNode generateTree(int[] preorder, List<Integer> inorder, int l, int r){
        if(l>r)return null;
        int curr = preorder[preIndex++];
        TreeNode root = new TreeNode(curr);

        int indexOfRoot = inorder.indexOf(curr);

        root.left = generateTree(preorder,inorder, l, indexOfRoot-1);
        root.right = generateTree(preorder,inorder, indexOfRoot+1, r);
        
        return root;
    }
}

// left-root-right 
// root-left-right 
