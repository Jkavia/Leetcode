// we'll use heap to track this based on the end time, peek element is the one getting done fastest
// now if new element starts at or after the peek element then we remove it and add the new ele
// constantly keep checking the size of the heap 
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0],b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));
        int max =0;
        for(int[] interval: intervals){
            while(!pq.isEmpty() && pq.peek()[1]<= interval[0]){
                pq.poll();
            }
            pq.add(interval);
            max = Math.max(max, pq.size());
        }

        return max;
    }
}