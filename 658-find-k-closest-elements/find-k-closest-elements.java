// we will use priority queue and store the distances 
// then we'll poll the queue to get the top 4
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> {
            if(Math.abs(a-x) == Math.abs(b-x)){
                return Integer.compare(a,b);
            }else{
                int num1 = Math.abs(a-x);
                int num2 = Math.abs(b-x);
                return Integer.compare(num1, num2);
            }
        });

        for(int a: arr){
            pq.add(a);
        }
        List<Integer> ret = new ArrayList<>();

        while(ret.size()<k){
            ret.add(pq.poll());
        }

        Collections.sort(ret);

        return ret;
    }
}

// 1 2 4 5 6
// 4 3 2 0 1