class Solution {

    public int[] twoSum(int[] nums, int target) {
        List<int[]> list = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            list.add(new int[]{nums[i],i});
        }

        Collections.sort(list, (a,b) -> Integer.compare(a[0],b[0]));

        int l=0,r=list.size()-1;

        while(l<r){
            int num = list.get(l)[0]+list.get(r)[0];
            if(num == target){
                return new int[]{list.get(l)[1], list.get(r)[1]};
            }else if(num > target){
                r--;
            }else{
                l++;
            }
        }

        return new int[2];
    }
}

// just parse through the array and look for target-curr in map and if its duplicate numbers also check 
// count > 1

