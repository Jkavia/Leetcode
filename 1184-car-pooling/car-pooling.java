class Solution {
    //Now since there are only 1000 stations 
    // we will create a list of these station and update the values with number of people who got in and got out there
    // when they get in we increase the value for that station with those ith number of people and when they get out we reduce it
    int[] stations = new int[1001];
    public boolean carPooling(int[][] trips, int capacity) {
        for(int[] arr:trips){
            int numpassenger = arr[0];
            int from = arr[1];
            int to = arr[2];

            stations[from] += numpassenger;
            stations[to] -= numpassenger;            
        }

        int currPassenger =0;

        for(int i=0;i<stations.length;i++){
            currPassenger += stations[i];
            if(currPassenger > capacity)return false;
        }
        return true;
    }
}