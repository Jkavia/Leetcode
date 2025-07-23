class Solution {
    public int[] twoSum(int[] nums, int target) {
        //since its not sorted so we use map, cause sorting it will lose the index
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            int lookup = target-num;
            if(map.containsKey(lookup)){
                return new int[]{map.get(lookup), i};
            }
            map.put(num, i);
        }

        return new int[2];
    }
}