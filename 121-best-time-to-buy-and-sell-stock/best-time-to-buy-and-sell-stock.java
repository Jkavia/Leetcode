class Solution {
    public int maxProfit(int[] prices) {

        int min = Integer.MAX_VALUE;
        int maxProf = Integer.MIN_VALUE;

        for(int price: prices){
            min = Math.min(min, price);
            maxProf = Math.max(maxProf, price-min);
        }

        return maxProf;
        
    }
}