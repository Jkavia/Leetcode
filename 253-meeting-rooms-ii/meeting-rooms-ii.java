class Solution {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        int max =0;
        for(int[] interval: intervals){
            if(!pq.isEmpty() && interval[0] >= pq.peek()[1]){
                pq.poll();
            }
            pq.add(interval);
            max = Math.max(max, pq.size());
        }

        return max;
    }
}

// maintain a min heap sorted by the end time 
// if you find an interval whose start time is after lowest end time 
// remove the top element and add this 
// keep a running track of heap size 