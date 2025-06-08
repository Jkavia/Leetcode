class Solution {
    public int maxProfit(int[] prices) {
        int minVal = Integer.MAX_VALUE;
        int maxPrf = 0;

        for (int i: prices){
            minVal = Math.min(minVal,i);
            maxPrf = Math.max(maxPrf, i-minVal);
        }
        return maxPrf;
    }
}