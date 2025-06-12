class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0],b[0]));
        List<int[]> ret = new ArrayList<>();

        for(int[] curr:intervals){
            if(ret.isEmpty()){
                ret.add(curr);
                continue;
            }
            int len = ret.size()-1;
            int[] retcurr = ret.get(len);
            if(curr[0] <= retcurr[1]){
                //merge needs to happen
                ret.get(len)[1] = Math.max(curr[1], retcurr[1]);
            }else{
                ret.add(curr);
            }
        }

        return ret.toArray(new int[0][]);
        
    }
}