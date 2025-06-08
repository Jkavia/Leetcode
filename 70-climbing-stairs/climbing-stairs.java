class Solution {
    public int climbStairs(int n) {
        if(n <= 2)return n;

        int last =2;
        int secondLast = 1;


        while (n > 2){
            int currStep = last+secondLast;
            secondLast = last;
            last = currStep;
            n--;
        }
        return last;

        
    }
}