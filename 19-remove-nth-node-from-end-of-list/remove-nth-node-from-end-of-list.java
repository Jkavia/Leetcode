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
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        int counter = 0;

        while(counter < n && first !=null){
            first = first.next;
            counter++;
        }

        if(first == null){
            return head.next;
        }

        ListNode prev = null, second = head;

        while(first !=null){
            first = first.next;
            prev = second;
            second = second.next;
        }

        prev.next = second.next;
        second.next =null;

        return head;
    }
}