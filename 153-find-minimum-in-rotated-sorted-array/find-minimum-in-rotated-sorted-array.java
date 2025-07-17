  // minimum number would be the one with larger numbers on both side. 
        // on the right side it will be increasing order so we need to move right pointer 
        // on the left side there is also increasing so we're gonna add another check if 
        // element is larger then last element then we know we're on the left triangle. 
        // in that case we'd want to move the left pointer

        
class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length-1;
        int lastElement= nums[r];
        // first element is the smallest. 
        if(nums[l]<nums[r])return nums[l];

        while(l<r){
            int mid = l + (r-l)/2;
            int element = nums[mid];
            if(nums[mid] > lastElement){
                l=mid+1;
            }else{
                r = mid;
            }
        }

        return nums[r];
        
    }

    //[3,4,5,1,2]
    // mid = 2, 3+(4-3)/2=3
    // l = 3
    // r = 3

    //[4,5,6,7,0,1,2]
    // mid = 3, 4+(6-4)/2 = 5, 4+(6-5)/2 = 4
    // l = 4
    // r = 4

}
//size - rotationTime becomes the first element. 
