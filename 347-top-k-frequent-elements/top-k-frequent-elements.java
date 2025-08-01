// can use the min heap to track the elements based on frequency and remove as size extends k
// other is have a list where index is fequency and all the elements with that fequency are there 
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] list = new List[nums.length+1];
        int[] ret = new int[k];
        for(int num:nums)map.put(num, map.getOrDefault(num,0)+1);

        for(int key: map.keySet()){
            int val = map.get(key);

            if(list[val] == null){
                list[val] = new ArrayList<>();
            }
            list[val].add(key);
        }
        int x =0;
        for(int i=list.length-1;i>=0 && x<k;i--){
            if(list[i] != null){
                for(int j=0;j<list[i].size() && x<k;j++){
                    ret[x++] = list[i].get(j);
                }
            }
        }
        return ret;
    }
}