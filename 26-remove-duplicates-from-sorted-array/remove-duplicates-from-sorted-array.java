class Solution {
    public int removeDuplicates(int[] nums) {
        int l=0,r=0;

        while(r<nums.length){
            if(nums[r] > nums[l]){
                nums[++l] = nums[r];
            }
            r++;
        }
        return l+1;
    }
}