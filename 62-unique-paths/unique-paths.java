class Solution {
    public int uniquePaths(int m, int n) {
        int[] north = new int[n];
        int west =0;

        for(int i=0;i<m;i++){
            west =0;
            int[] temp = new int[n];
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    west= 1;
                }else{
                int up = (i==0)?0:north[j];
                int left = (j==0)?0:west;
                west = up+left;         
                }
                temp[j] = west;
        }
        north = temp;
        }

        return north[n-1];
    }
}