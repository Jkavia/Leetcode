class Solution {
    public int longestConsecutive(int[] nums) {
        //save the values in set, look for the smallest value for each sequence and run a while loop for +1 of that value
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for(int num:nums){
            set.add(num);
        }
        
        for(int num:set){
            if(!set.contains(num-1)){
                int curr = num;
                int count = 0;
                while(set.contains(curr)){
                    count++;
                    curr++;
                }
                if(count > max){
                    max = count;
                }
         
            }
        }
        return max;

    }
}