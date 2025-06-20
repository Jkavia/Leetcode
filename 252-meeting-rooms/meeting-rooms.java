class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        for(int i =0;i<intervals.length-1;i++){
            int[] meeting1 = intervals[i];
            int[] meeting2 = intervals[i+1];
            // if first meeting is ending after the starting of first then there is clash
            if(meeting1[1] > meeting2[0]) return false;
        }
        return true;
    }
}