class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length < 1) return 0;
        Set<Integer> set = new HashSet<>();

        for(int num:nums){
            set.add(num);
        }
        int maxLen =1;
        int tempLen =0;

        for(int num:set){
            if(!set.contains(num-1)){
                int val = num;
                while(set.contains(val)){
                    tempLen++;
                    val = val+1;
                }
            }
            maxLen = Math.max(maxLen, tempLen);
            tempLen = 0;
        }

        return Math.max(maxLen, tempLen);
    }
}