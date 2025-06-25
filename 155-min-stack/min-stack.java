class MinStack {
    ListNode head;

    public MinStack() {
        head = null;
    }

    public void push(int val) {
        if(head == null){
            head = new ListNode(val, null, val);
        }else{
            int newMin = (val < head.min)?val: head.min;
            ListNode temp = new ListNode(val, head, newMin);
            head = temp;
        }
    }

    public void pop() {
        if(head != null){
            ListNode temp = head;
            head = head.next;
            temp.next = null;
        }
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
}

class ListNode {
    int val;
    ListNode next;
    int min;

    public ListNode(int val, ListNode next, int min) {
         this.val = val;
         this.next = next;
         this.min = min;
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