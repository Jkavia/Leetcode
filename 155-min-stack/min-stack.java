
//Approach: we want to create a LinkedList that tracks, next node, val and min value until that node. 
// The top will always be head so we'll add all the new values in front. 

class MinStack {
ListNode head;

    public MinStack() {
        head = null;
    }
    
    public void push(int val) {
        if(head == null){
            head = new ListNode(val,val,null);
        }else{
            int minVal = Math.min(val, head.min);
            ListNode curr = new ListNode(val, minVal, head);
            head = curr;
        }
    }
    
    public void pop() {
        if(head!=null){
        ListNode curr = head;
        head = head.next;
        curr.next = null;
        }
    }
    
    public int top() {
        if(head !=null){
        return head.val;
        }else return 0;
    }
    
    public int getMin() {
       if(head !=null){
        return head.min;
       }else return 0;
    }
}

class ListNode{
    int val;
    int min;
    ListNode next;

    public ListNode(int val, int min, ListNode next){
        this.val = val;
        this.min = min;
        this.next = next;
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */