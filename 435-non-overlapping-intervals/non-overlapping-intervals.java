class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1],b[1]));
        int[] prev = intervals[0];
        int count =1;

        for(int i=1;i<n;i++){
            if(intervals[i][0] >= prev[1]){
                count++;
                prev = intervals[i];
            }
        }

        return n-count;
    }
}

// we'll sort this by end time and then we'll see which are the intervals that we 
// can accomoate without conflict and we'll track the index of last accomoated interval 
// once we have list of all the accomodated intervals then we'll subtrqact that from total 
// to know the intervals that weren't accomodated. 