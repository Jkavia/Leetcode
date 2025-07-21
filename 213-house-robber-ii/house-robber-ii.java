class Solution {

    public int rob(int[] nums) {
 
        int len = nums.length;

        if(len < 3){
            int max = (len < 2)? nums[0]:Math.max(nums[0], nums[1]);
            return max;
        }
        // avoid last
        int sum1 = robHouses(nums, 0, len-1);
        // avoid first
        int sum2 = robHouses(nums, 1, len);

        return Math.max(sum1, sum2);
    }

    public int robHouses(int[] nums, int x, int y){
        int prev =0;
        int prePrev =0;
        int max =0;

        for(int i=x;i<y;i++){
            int currMax = Math.max(prev, prePrev+nums[i]);
            max = Math.max(max, currMax);
            prePrev = prev;
            prev = currMax;
        }
        return max;
    }
}