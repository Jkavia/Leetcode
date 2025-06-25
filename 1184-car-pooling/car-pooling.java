class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int limCap = capacity;
        
        PriorityQueue<int[]> earliestDestination = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        // keep track of prevStart so that next start can not be lesser i.e. in west.
        int prevStart = Integer.MIN_VALUE;
        Arrays.sort(trips, (a,b) -> Integer.compare(a[1],b[1]));
        for(int[] trip: trips){
            int earliestDest = 
            earliestDestination.isEmpty()? Integer.MAX_VALUE: earliestDestination.peek()[0];
            
            //east to west move next starting is before the start of prev. 
            if(trip[1] < prevStart)return false;
            if(trip[1] < earliestDest){
                if(capacity - trip[0] <0){
                    return false;
                }else{
                    capacity -= trip[0];
                    earliestDestination.add(new int[]{trip[2], trip[0]});
                }
            }else{
                //Adjust capacity first then check if current trip can be made
                while(!earliestDestination.isEmpty()){
                    if(earliestDestination.peek()[0] <= trip[1]){
                        int[] val = earliestDestination.poll();
                        
                        capacity = capacity + val[1];
                        System.out.println(" val0 "+val[0]+" val1"+val[1]+" cap "+capacity);
                        if(capacity > limCap){
                            capacity = limCap;
                        }
                    }else{
                        break;
                    }
                }

                if(capacity - trip[0] <0) return false;
                capacity -= trip[0];
                earliestDestination.add(new int[]{trip[2], trip[0]});
            }
            prevStart = trip[1] ;
        }

        return true;

    }
}