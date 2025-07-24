class Solution {
    public void sortColors(int[] nums) {
        int zPtr =0, tPtr = nums.length-1;
        int curr = 0;
        while(curr <= tPtr){
            if(nums[curr] == 0){
                swap(zPtr, curr, nums);
                zPtr++;
                curr++;
            }else if(nums[curr] == 2){
                swap(tPtr, curr, nums);
                tPtr--;
            }else{
                curr++;
            }
        }
    }

    public void swap(int p1, int p2, int[] nums){
        int temp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp;
    }
}