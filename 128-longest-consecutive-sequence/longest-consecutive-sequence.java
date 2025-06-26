class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length < 1) return 0;
        TreeSet<Integer> minHeap = new TreeSet<>();

        for(int num:nums){
            minHeap.add(num);
        }
        int maxLen =1;
        int prev = minHeap.pollFirst();
        int tempLen =1;

        while(!minHeap.isEmpty()){
            int curr = minHeap.pollFirst();

            if(prev+1 == curr){
                tempLen++;
            }else{
                maxLen = Math.max(maxLen, tempLen);
                tempLen = 1;
            }
            prev = curr;
        }

        return Math.max(maxLen, tempLen);
    }
}