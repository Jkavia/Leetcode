class Solution {
    public int removeDuplicates(int[] nums) {
        int l=0,r=0;

        while(r<nums.length){
            if(nums[r] > nums[l]){
                nums[++l] = nums[r++];
            }else{r++;}
        }
        return l+1;
    }
}
//                   r
//[0,1,2,3,4,2,2,3,3,4]
//         l