class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for(int i =1;i<dp.length;i++){
            for(int coin: coins){
                int remaining = i-coin;
                if(remaining >=0){
                    dp[i] = Math.min(dp[i], 1+dp[remaining]);
                }
            }
        }

        return dp[amount] == amount+1?-1:dp[amount];
    }
}
// this is a dp question, from 0 to amount we'll calculate the min required based on 
// each of the denominations 