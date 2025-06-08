class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int p1 = 0, p2=nums.length-1;
        Map<Integer, Integer> imap = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(imap.containsKey(target-nums[i])){
                return new int[]{imap.get(target-nums[i]),i};
            }
            imap.put(nums[i],i);
        }

        return new int[2];
    }
}