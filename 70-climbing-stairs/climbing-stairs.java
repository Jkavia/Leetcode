class Solution {
    public int climbStairs(int n) {
        if(n<=2)return n;

        int prev = 2;
        int prePrev = 1;
        int total =0;

        for(int i=3;i<=n;i++){
            total = prev+prePrev;
            prePrev = prev;
            prev = total;
        }
        return total;
    }
}