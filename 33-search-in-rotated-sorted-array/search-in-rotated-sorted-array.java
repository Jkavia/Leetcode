class Solution {
    public int search(int[] nums, int target) {
        //1. find the rotation axis 
        //2. find the element before/after that axis. 

        int l=0,r=nums.length-1, axis =0, element = nums[nums.length-1];

// look at the last element and then compare the mid points with that
        while(l<=r){
            int mid = l + (r-l)/2;
            
            if(nums[mid] > element){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        
        axis = l-1;

        int left = (target>nums[nums.length-1])?0:axis+1;
        int right = (target>nums[nums.length-1])? axis : nums.length-1;
      
        while(left<=right){
              //System.out.println(left+".  "+right);
            int mid = left + (right-left)/2; //4 +1 = 5(1)  

            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        return -1;

    }
}