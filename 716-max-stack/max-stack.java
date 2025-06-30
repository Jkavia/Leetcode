class MaxStack {
    TreeSet<int[]> pq;
    TreeSet<int[]> topPq;
    int counter;

    public MaxStack() {
        counter = 0;
        pq = new TreeSet<>((a,b) -> {
        if(Integer.compare(b[0], a[0]) == 0){
            return Integer.compare(b[1], a[1]);
        }
            return Integer.compare(b[0], a[0]);});
        topPq = new TreeSet<>((a,b) -> Integer.compare(b[1],a[1]));
    }
    
    public void push(int x) {
        int[] arr = new int[]{x,counter};
        pq.add(arr);
        topPq.add(arr);
        counter++;

    }
    
    public int pop() {
        int[] arr = topPq.pollFirst();
        pq.remove(arr);
        return arr[0];
    }
    
    public int top() {
        return topPq.first()[0];
    }
    
    public int peekMax() {
        return pq.first()[0];
    }
    
    public int popMax() {
        int[] arr = pq.pollFirst();
        topPq.remove(arr);
        return arr[0];
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