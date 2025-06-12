class Solution {
    public boolean canJump(int[] nums) {
        int i =0;
        int stepsAvail = nums[0];

        while(i<nums.length){
            stepsAvail = Math.max(stepsAvail, nums[i]);
            if(stepsAvail == 0 && i<nums.length-1){
                return false;
            }
            stepsAvail --;
            i++;
        }
        return true;
        
    }
}