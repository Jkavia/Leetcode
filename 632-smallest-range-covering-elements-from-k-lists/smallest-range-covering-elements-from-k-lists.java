class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)-> Integer.compare(a.val, b.val));
        int maxVal = Integer.MIN_VALUE;
        

        for(int i=0;i<nums.size();i++){
            int val = nums.get(i).get(0);
            Node node = new Node(i,0,val);
            pq.add(node);
            maxVal = Math.max(maxVal, val);
        }
        int[] minRange = new int[]{pq.peek().val, maxVal};
        
        while(true){
            Node node = pq.poll();
            int val = node.val;
            int list = node.list;
            int idx = node.idx;

            if(maxVal - val < minRange[1] - minRange[0]){
                minRange[0] = val;
                minRange[1] = maxVal;
            }

            if(idx+1 >= nums.get(list).size())break;
            int newIdx = idx+1;
            int newVal = nums.get(list).get(newIdx);
            maxVal = Math.max(maxVal, newVal);
            Node tempNode = new Node(list, newIdx, newVal);
            pq.add(tempNode);
        }

        return minRange;

    }
}

class Node {
    int list;
    int idx;
    int val;

    public Node(int list, int idx, int val){
        this.list = list;
        this.idx = idx;
        this.val = val;
    }
}