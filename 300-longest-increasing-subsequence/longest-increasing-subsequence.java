class Solution {

    public int lengthOfLIS(int[] nums) {
        List<Integer> lst = new ArrayList<>();
        int max = 1;
        for(int n:nums){
            if(!lst.isEmpty() && lst.get(lst.size()-1)>=n){
                binarySearchReplace(lst, n);
            }else{
                lst.add(n);
                max = Math.max(max, lst.size());
            }
        }

        return max;
    }


    public void binarySearchReplace(List<Integer> lst, int n){
        int l=0, r=lst.size()-1;

        while(l<r){
            int mid = l+(r-l)/2;

            if(lst.get(mid) == n){
                l = mid;
                break;
            }else if(lst.get(mid) > n){
                r = mid;
            }else{
                l = mid+1;
            }
        }

        lst.set(l, n);
    }
}