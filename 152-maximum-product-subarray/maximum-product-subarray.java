
// keep the track of both max and min value
// re-calcualte them at each index again (as -ve elements can switch that)
// use the currMax at that index to find the global max.
class Solution {
    public int maxProduct(int[] nums) {
        int currMax = nums[0], currMin = nums[0], max = nums[0];

        for(int i =1;i<nums.length;i++){
            int tempMax = currMax;
            currMax = Math.max(Math.max(currMax*nums[i], currMin*nums[i]), nums[i]);
            currMin = Math.min(Math.min(tempMax*nums[i], currMin*nums[i]), nums[i]);
            max = Math.max(max, currMax);
        }

        return max;
    }
}

// since double negative can make current min current max and one negative can make curr max into curr min
// therefore we track both of those and use that to calculate max.
// so at a given point there are three possibilities. 
// min * val or max * val or val itself. 
