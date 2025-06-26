class Solution {
    public int longestConsecutive(int[] nums) {
        //save these values in a set 
        // parse the set and check if a value exist for val[i]-1 if it doesnt 
        // then i know it is the lowest number for that consecutive sequence 
        // run a while loop on that value and keep adding 1 to it, as long as these consecutive values 
        // exist in set, once its over compare with maxLen and update accordingly 

        Set<Integer> numsSet = new HashSet<>();
        for(int i:nums){
            numsSet.add(i);
        }

        int longest = 0, tempSeq =0;

        for(int num: numsSet){
            if(!numsSet.contains(num-1)){
                int val = num;
                while(numsSet.contains(val)){
                    tempSeq++;
                    val++;
                }
                longest = Math.max(longest, tempSeq);
                tempSeq = 0;
            }
        }

        return longest;
        
    }
}