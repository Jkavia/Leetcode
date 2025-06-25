class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        //since there are only 1000 stops we just need to track how many people 
        // got in/out of the car and then we can just iterate through the stops 
        //adjusting our capacity and comparing it to overall, if it goes above the limit we return false

        int[] destinations = new int[1001];
        for(int[] trip:trips){
            int passenger = trip[0];
            int st = trip[1];
            int end = trip[2];
            destinations[st] += passenger;
            destinations[end] -= passenger;
        }

        int currCapacity =0;
        for(int i =0;i<destinations.length;i++){
            currCapacity += destinations[i];

            if(currCapacity > capacity)return false;
        }
        return true;
    }
}