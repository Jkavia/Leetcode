class Solution {
    public int[] countBits(int n) {
        int[] ret = new int[n+1];
        for(int i=1;i<=n;i++){
            ret[i] = ret[i>>>1] + (i&1);
        }
        return ret;
    }
}