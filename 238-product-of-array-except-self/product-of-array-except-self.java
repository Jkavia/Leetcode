class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] tmeparr = new int[nums.length];
        int prev = 1;
        for(int i=0;i<nums.length;i++){
            tmeparr[i] = prev*nums[i];
            prev = tmeparr[i];
        }

        prev = 1;

        for(int i=nums.length-1;i>=0;i--){
            int temp = nums[i];
            if(i==0){nums[i] = prev; continue;}
            nums[i] = tmeparr[i-1]*prev;
            prev = prev*temp;
        }

        return nums;
        
    }
}