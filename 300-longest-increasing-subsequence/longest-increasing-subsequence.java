class Solution {
    // maintain a sorted array 
    // if you find the element larger than the last element
    // do a bst and replce it with the closest one to that 
    // keep checking the size of this sorted array 
    public int lengthOfLIS(int[] nums) {
        
        List<Integer> lst = new ArrayList<>();
        int max = 0;

        for(int n: nums){
            if(!lst.isEmpty() && lst.get(lst.size()-1) >= n){
                doBstReplace(n, lst);
            }else{
                lst.add(n);
            }
            max = Math.max(max, lst.size());
        }
        return max;
    }

    public void doBstReplace(int n, List<Integer> lst){
        int left =0, right = lst.size()-1;

        while(left < right){
            int mid = left + (right-left)/2;

            if(lst.get(mid) == n){
                left = mid;
                break;
            }else if(lst.get(mid) > n){
                right = mid;
            }else{
                left = mid+1;
            }
        }

        lst.set(left,n);
    }


}