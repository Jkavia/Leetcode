class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> ret = new ArrayList<>();

        if(intervals == null || intervals.length<1){
            ret.add(newInterval);
            return ret.toArray(new int[0][]);
        }
        int i;
        int[] last ={};

        for(i=0;i<intervals.length;i++){
            int[] curr = intervals[i];
            if(curr[1] >= newInterval[0]){
                if(newInterval[1] < curr[0]){
                    last = newInterval;
                }else{
                curr[1] = Math.max(curr[1],newInterval[1]);
                curr[0] = Math.min(curr[0], newInterval[0]);
                last = curr;
                i++;
                if(i == intervals.length){
                    ret.add(curr);
                    return ret.toArray(new int[0][]);
                }
                }
                break;
            }else{
                ret.add(curr);
                if(i == intervals.length-1){
                    ret.add(newInterval);
                    return ret.toArray(new int[0][]);
                }
            }
        }

        for(int j=i;j<intervals.length;j++){
            int[] curr = intervals[j];

            if(last[1] >= curr[0]){
                last[0] = Math.min(curr[0], last[0]);
                last[1] = Math.max(curr[1], last[1]);
            }else{
                ret.add(last);
                last = curr;
            }
        }

        ret.add(last);

        return ret.toArray(new int[0][]);

        
    }
}