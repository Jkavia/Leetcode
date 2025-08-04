class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> sorted = new ArrayList<>();
        int maxLen = 0;

        for(int num: nums){
            if(sorted.isEmpty() || sorted.get(sorted.size()-1)<num){
                sorted.add(num);
            }else{
                replace(sorted, num);
            }
            maxLen = Math.max(maxLen, sorted.size());
        }
        return maxLen;
    }

    public void replace(List<Integer> sorted, int num){
        int left=0, right= sorted.size()-1;

        while(left<right){
            int mid = left+(right-left)/2;
            if(num == sorted.get(mid)){
                left = mid;
                break;
            }else if(num > sorted.get(mid)){
                left = mid+1;
            }else{
                right = mid;
            }
        }

        sorted.set(left, num);
    }
}

// maintain a sorted array and whenever you encounter an element thats not incresing
// replace an element in the array with that such that its closest to its value 
// to find the replacement point just do a binary search.