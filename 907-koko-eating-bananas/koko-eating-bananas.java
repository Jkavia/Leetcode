// here we'll do a binary search between 1(min time i.e. 1 banana per hour) and max_banana_in_lot(time)
// and try to find its mid point and then take that mid point as a speed i.e. x bananas/hour and call a 
// helper function to get number of hours it takes to finish bananas at that speed.
// if the hours value is > h then we move right pointer to mid and 
// if its < h then we move the left pointer to mid+1

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1,right = Integer.MIN_VALUE;
        for(int pile:piles){
            right = Math.max(right, pile);
        }

        //do binary search 
        while(left <= right){
            int mid = left + (right-left)/2;

            if(checkHoursNeededAtMidSpeed(piles, h, mid)){
                //if this speed gives time equal or less than available then we can reduce speed
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        return left;

    }

    public boolean checkHoursNeededAtMidSpeed(int[] piles, int h, int mid){
        long totalTime = 0;
        for(int pile:piles){
            long h1 = pile/mid;
            long h2 = (pile%mid == 0)?0:1;
            totalTime += h1+h2;
        }
        return totalTime <= h;
    }

}

// psedo code 
// 1 2 3 4 5 6 7 8 9 10 11   h = 4
// mid = 6
// h1 = val/mid and if (val%mid!=0) h1+1; 1+1+2+2
// so 6 hours > 4 since its taking longer than allowed we need to increase our speed
// left = mid+1 = 4
// new mid = 4+11-4/2 = 7
// h1 = 1+1+1+2 
// so 5 hours > 4 we need to increase speed bit more 
// left = mid+1 = 8
// new mid = 8+(11-8)/2 = 9
// h1 = 1+1+1+2 = 5
// 5 > 4 need to increase speed
// left = 9+1 = 10 
// new mid = 10+11-10/2 = 10
// h1 = 1+1+1+2
// 5 > 4 need to increase the speed
// left = mid+1 = 11
// mid = 11+11-11/2 = 11
// h1 = 1+1+1+1 = 4
// now make right mid -1 = 10 and loop breaks and speed is left. 