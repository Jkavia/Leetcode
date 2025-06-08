class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0)return 0;
        Arrays.sort(nums);
        int currSeq =1;
        int longestseq =0;
        int prev = nums[0];
        

        for(int i=1;i<nums.length;i++){
            if(nums[i] == prev+1){
                currSeq++;
            }else if(nums[i] == prev){
                //do nothing
            }else{
                longestseq = Math.max(currSeq, longestseq);
                currSeq =1;
            }
            prev = nums[i];
        }
        return Math.max(currSeq, longestseq);
    }
}