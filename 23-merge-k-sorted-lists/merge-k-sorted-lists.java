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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.val, b.val));
        
        for(ListNode node: lists){
            if(node!=null){
                pq.add(node);
            }
        }
        ListNode nxt = head;

        while(!pq.isEmpty()){
            ListNode curr = pq.poll();
            if(curr.next != null){
                pq.add(curr.next);
            }
            nxt.next = curr;
            nxt = nxt.next;
        }

        return head.next;
    }
}

// add the k listnode to heap 
// now while heap is non null pull the top and add the next element to peak if non null