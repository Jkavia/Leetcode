class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] list = new List[nums.length+1];
        int[] ret = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        for(int key: map.keySet()){
            int count = map.get(key);
            if(list[count] == null){
                list[count] = new ArrayList<>();
            }
            list[count].add(key);
        }
        int x=0;
        for(int i=list.length-1;i>=0 && x<k;i--){
            if(list[i]!=null){
                for(int j=0;j<list[i].size() && x<k;j++){
                    ret[x++] = list[i].get(j);
                }
            }
        }
        return ret;
    }
}
// create a min heap and remove when size > k and last k are the top ones O(nlogn)
// create a frequency list  O(n)