class Solution {
    public int rob(int[] nums) {
        if(nums.length < 3){
            int max = (nums.length<2)?nums[0]:Math.max(nums[0],nums[1]);
            return max;
        }
        int maxFromZeroToNminusOne = robHouses(nums, 0, nums.length-2);
        int maxFromOneToN = robHouses(nums, 1, nums.length-1);

        return Math.max(maxFromZeroToNminusOne,maxFromOneToN); 
    }

    public int robHouses(int[] nums, int l, int r){
        int prev = 0;
        int prePrev = 0;
        int max = 0;

        for(int i=l;i<=r;i++){
            int currMax = Math.max(nums[i]+prePrev, prev);
            max = Math.max(max, currMax);
            prePrev = prev;
            prev = currMax;
        }

        return max;
    }
}