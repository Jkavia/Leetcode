class Solution {
    public int rob(int[] nums) {

        int nMinusOne = 0, nMinusTwo=0;
        int currMax = Integer.MIN_VALUE;

        for(int num:nums){
            currMax = Math.max(nMinusOne, nMinusTwo+num);
            nMinusTwo = nMinusOne;
            nMinusOne = currMax;
        }

        return currMax;
        
    }
}

// gotta keep a running track of whats greater, n-1 or curr+n-2
//[1,2,3,1]
//n-1 = 1(currMax), 2,4,4
//n-2 = 0(n-1), 1,2,4
// currMax = max(n-1, curr+n-2) =1 , max(1, 2+0) =2, max(2, 3+1)=4, max(4, 1+2)=4