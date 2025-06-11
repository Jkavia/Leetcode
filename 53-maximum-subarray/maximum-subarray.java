class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int max = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];

        for(int i=0;i<nums.length;i++){
            int prev = (i==0)? 0: dp[i-1];
            dp[i] = Math.max(nums[i]+prev, nums[i]);
            max = Math.max(dp[i],max);
        }

        return max;
    }
}