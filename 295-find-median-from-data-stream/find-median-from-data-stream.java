class MedianFinder {
        PriorityQueue<Integer> minHeap;
        PriorityQueue<Integer> maxHeap;
        int size;

    public MedianFinder() {
        minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a,b));
        maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        size =0;
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || maxHeap.peek()>= num){
            maxHeap.add(num);
        }else{
            minHeap.add(num);
        }

        if(maxHeap.size() > minHeap.size()+1){
            minHeap.add(maxHeap.poll());
        }else if(maxHeap.size() < minHeap.size() && !minHeap.isEmpty()){
            maxHeap.add(minHeap.poll());
        }
        size++;
    }
    
    public double findMedian() {
        if(size%2 ==1){
            return maxHeap.peek();
        }else{
            double val = ((double)maxHeap.peek() + (double)minHeap.peek())/2;
            return val;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */