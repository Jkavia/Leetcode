class MaxStack {
    TreeSet<StackEntry> setOrder;
    TreeSet<StackEntry> setMax;
    int order;

    public MaxStack() {
        setOrder = new TreeSet<>((a,b) -> Integer.compare(b.order,a.order));
        setMax = new TreeSet<>((a,b) -> {
            int comp = Integer.compare(b.val,a.val);
            if(comp != 0){
                return comp;
            }
            return Integer.compare(b.order,a.order);
            });
        order =0;
        
    }
    
    public void push(int x) {
        StackEntry se = new StackEntry(x,order);
        setOrder.add(se);
        setMax.add(se);
        System.out.println(setMax.first().val);
        order++;
    }
    
    public int pop() {
        StackEntry se = setOrder.pollFirst();
        setMax.remove(se);
        return se.val;
    }
    
    public int top() {
        return setOrder.first().val;
    }
    
    public int peekMax() {
        return setMax.first().val;
    }
    
    public int popMax() {
        StackEntry se = setMax.pollFirst();
        setOrder.remove(se);
        return se.val;
    }
}

class StackEntry{
    int val;
    int order;

    public StackEntry(int val, int order){
        this.val = val;
        this.order = order;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */