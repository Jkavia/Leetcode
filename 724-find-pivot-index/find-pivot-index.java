class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum =0;
        for(int num:nums){
            totalSum+=num;
        }

        int pivot =-1;
        int prev = 0;

        for(int i=0;i<nums.length;i++){
            totalSum -= nums[i];
            if(prev == totalSum) return i;
            prev += nums[i];
        }

        return pivot;
        
    }
}