/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        
        List<Integer> sortedList = new ArrayList<>();
        ListNode temp = head;
        while(temp != null){
            sortedList.add(temp.val);
            temp = temp.next;
        }
        int left = 0, right = sortedList.size()-1;
        return createBst(sortedList, left, right);
    }

    public TreeNode createBst(List<Integer> sortedList, int left, int right){
        if(right < left)return null;

        int mid = left + (right-left)/2;
        int midVal = sortedList.get(mid);
        TreeNode root = new TreeNode(midVal);

        root.left = createBst(sortedList, left, mid-1);
        root.right = createBst(sortedList, mid+1 , right);

        return root;
    }
}