class Solution {
    public int maxArea(int[] height) {
        // two pointers 
        int left =0, right = height.length-1;
        int maxarea = 0;
        
        while(left<right){
            int leftHeight = height[left];
            int rightHeight = height[right];
            int minHeight = Math.min(leftHeight, rightHeight);
            maxarea = Math.max(maxarea, minHeight *(right-left));

            if(leftHeight < rightHeight){
                left ++;
            }else{
                right--;
            }
        }

        return maxarea;

    }
}