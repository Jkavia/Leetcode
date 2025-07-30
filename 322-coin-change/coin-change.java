
// do a dynamic programming for all the amount from 0 to amount. 
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0]=0;

        for(int i=1;i<amount+1;i++){
            for(int j=0;j<coins.length;j++){
                int diff = i-coins[j];
                if(diff >= 0){
                    dp[i] = Math.min(dp[i], 1+dp[diff]);
                }
            }
        }

        return dp[amount] == amount+1 ? -1:dp[amount];
    }
}