class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ret = new int[k];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));
        for(int num:nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        for(int key: map.keySet()){
            pq.add(new int[]{key, map.get(key)});
            if(pq.size()>k)pq.poll();
        }
        int i=0;
        while(!pq.isEmpty()){
            int[] val = pq.poll();
            ret[i++] = val[0];
        }
        return ret;

    }
}