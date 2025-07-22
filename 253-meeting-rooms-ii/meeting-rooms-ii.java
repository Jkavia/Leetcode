class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0],b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> Integer.compare(a[1],b[1]));
        int max = 1;
        for(int[] interval:intervals){
            while(!pq.isEmpty() && pq.peek()[1]<= interval[0]){
                pq.poll();
            }
            pq.add(interval);
            max = Math.max(max, pq.size());
        }
        return max;
    }
}

// use min-heap to track the rooms that are going to get vacated the earliest 
// and iterate over sorted list to add/remove rooms based on that 