class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int remaining = target-nums[i];
            if(map.containsKey(remaining)){
                return new int[]{map.get(remaining),i};
            }
            map.put(nums[i],i);
        }

        return new int[2];
    }
}

// just parse through the array and look for target-curr in map and if its duplicate numbers also check 
// count > 1

