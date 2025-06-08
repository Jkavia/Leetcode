class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            if(nums[i]>0)break;

            int p1=i+1;
            int p2 = nums.length-1;

            while(p1 < p2){
                int sum = nums[p1]+nums[p2]+nums[i];

                if(sum == 0){
                    List<Integer> temp = Arrays.asList(nums[p1],nums[p2],nums[i]);
                    ret.add(temp);
                    p2--;
                    p1++;
                    while(p1<p2 && nums[p2]==nums[p2+1]){
                        p2--;
                    }
                    while(p1<p2 && nums[p1]==nums[p1-1]){
                        p1++;
                    }
                }else if(sum >0){
                    p2--;
                    while(p1<p2 && nums[p2]==nums[p2+1]){
                        p2--;
                    }
                }else{
                     p1++;
                    while(p1<p2 && nums[p1]==nums[p1-1]){
                        p1++;
                    }
                }
            }
        }

        return ret;
    }
}