class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals == null || intervals.length <1 ) return new int[][]{newInterval};
        List<int[]> ret = new ArrayList<>();

        // we'll divide the problem into three parts,


 

        int newStart = newInterval[0], newEnd = newInterval[1];
        int i=0;
        // first well add all the intervals that are before the beginning of newInterval
        while(i <intervals.length && intervals[i][1] < newStart){
            ret.add(intervals[i]);
            i++;
        }
        // second we'll add all the intervals that are merging with the new interval 
        while(i <intervals.length && newEnd >= intervals[i][0]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        ret.add(newInterval);
       // last we'll add the remaining ones. 
       while(i < intervals.length){
        ret.add(intervals[i]);
        i++;
       }

       return ret.toArray(new int[0][]);

    }
}