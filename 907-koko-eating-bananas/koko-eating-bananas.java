//we'll do a binary search from 1 to 1000000000 (as its the max value)
// at each mid point we'll check if the hours taken are more or less that available
// based on that info we'll move our left and right pointers. 

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left =1;
        int right = 0;// defined max possible value, if not we can do a loop to get max 
        for(int val: piles){
            right = Math.max(right, val);
        }

        while(left<=right){
            int mid = left+(right-left)/2;
            System.out.println("mid:" +mid);

            if(canEatInTime(mid, piles, h)){
                //need to reduce the speed
                right = mid-1;
            }else{
                //need to increase the speed.
                left = mid+1;
            }
        }

        return left;
    }

    public boolean canEatInTime(int mid, int[] piles, int h){
        long hours =0;

        for(int pile: piles){
            int div = pile/mid;
            hours = hours+div;
            if(pile%mid != 0)hours++;
        }
        //System.out.println("hours:" +hours);
        return (hours>=0 && hours <= h);
    }


}