class Solution {
    public int climbStairs(int n) {
        if(n<3)return n;
        int[] arr = new int[n+1];
        arr[1]=1;
        arr[2]=2;
        for(int i=3;i<arr.length;i++){
            arr[i] = arr[i-1]+arr[i-2];
        }
        return arr[n];
    }
}

// no of ways to reach the current spot = (no of ways to reach n-1)+(no of ways to reach n-2)
