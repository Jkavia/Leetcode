class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prev =1;
        int[] products = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            products[i] = nums[i]*prev;
            prev = products[i];
        }

        prev =1;

        for(int i=nums.length-1;i>=0;i--){
            int temp = nums[i];
            if(i==0){
                nums[i] = prev;
                continue;
            }
            nums[i] = products[i-1]*prev;
            prev = prev*temp;
        }

        return nums;
    }
}