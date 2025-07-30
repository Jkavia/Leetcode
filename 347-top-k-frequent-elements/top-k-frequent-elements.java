// solution with bucket that will store the values against their frequencies 

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length+1];
        Map<Integer, Integer> freqMap = new HashMap<>();
        int[] ret = new int[k];
        int j=0;
        for(int n:nums){
            freqMap.put(n, freqMap.getOrDefault(n, 0)+1);
        }
        for(int key: freqMap.keySet()){
            int count = freqMap.get(key);
            if(bucket[count] == null){
                bucket[count] = new ArrayList<>();
            }
            bucket[count].add(key);
        }

        for(int i=bucket.length-1;i>0 && j<k; i--){
            if(bucket[i] != null){
                for(int x=0;x<bucket[i].size() && j<k;x++){
                    ret[j++] = bucket[i].get(x);
                }
            }
        }
        return ret;
    }
}