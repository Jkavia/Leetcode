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
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> Integer.compare(b,a));
        searchKthSmallest(pq, root, k);
        while(pq.size() > k)pq.poll();
        return pq.peek();
    }


    public void searchKthSmallest(PriorityQueue<Integer> pq, TreeNode root, int k){
        if(root == null)return;

        if(pq.size() > k)pq.poll();

        pq.add(root.val);
        searchKthSmallest(pq, root.left, k);
        searchKthSmallest(pq, root.right, k);
    }
}