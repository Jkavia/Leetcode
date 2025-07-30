//use dp array 
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for(int i=1;i<dp.length;i++){
            for(int j=0;j<coins.length;j++){
                int curramount = i - coins[j];// any number smaller than that has been pre-computed 
                // for min coins needed. and then you re-use that in dp.
                if(curramount >= 0){
                    dp[i] = Math.min(dp[i], 1+dp[curramount]);
                    //[0,13,13,13,13,13,13,13,13,13,13, 13]
                    // 0 1  2  3. 4. 5. 6. 7  8. 9. 10. 11
                }
            }
        }

        return (dp[amount] == amount+1 )?-1:dp[amount];
    }
}