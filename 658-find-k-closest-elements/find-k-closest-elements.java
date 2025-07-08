class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //we will try to do a binary search to find out the range 
        // where we can get the K closest elements 

        int left =0, right = arr.length - k;
        // we subtracted K from right to accomodate for the calculations if range comes out to be last k elements 

        while(left < right){
            int mid = left + (right-right)/2;

            if(x- arr[mid] > arr[mid+k] - x){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        List<Integer> ret = new ArrayList<>();
        for(int i=left;i<left+k;i++){
            ret.add(arr[i]);
        }

        return ret;
    }
}