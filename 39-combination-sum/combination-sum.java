class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> retlist = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        backtrack(retlist, temp,candidates, target, 0);

        return retlist;
    }


    private void backtrack(List<List<Integer>> retlist,List<Integer> temp,int[] candidates,int target, int idx){
        System.out.println(target);
        if(target == 0){
            retlist.add(new ArrayList<>(temp));
            return;
        }

        for(int i=idx;i<candidates.length;i++){
            if(target - candidates[i] >=0){
                temp.add(candidates[i]);
                backtrack(retlist, temp, candidates, target-candidates[i],i);
                temp.remove(temp.size()-1);
            }
        }
    }
}