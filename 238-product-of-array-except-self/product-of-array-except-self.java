class Solution {
    public int[] productExceptSelf(int[] nums) {
        int left =1;
        int[] ret = new int[nums.length];

        for(int i=0;i<ret.length;i++){
            ret[i] = left*nums[i];
            left = ret[i];
        }
        int right = 1;

        for(int i=ret.length-1;i>=0;i--){
            if(i==0){
                ret[i] = right;
            }else{
                ret[i] = right * ret[i-1];
            }
            right = right*nums[i];
        }

        return ret;
    }
}