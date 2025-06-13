class Solution {
    public int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    matrix[i][j]= 1;
                }else{
                int up = (i==0)?0:matrix[i-1][j];
                int left = (j==0)?0:matrix[i][j-1];
                matrix[i][j]= up+left;            
                }
        }
        }

        return matrix[m-1][n-1];
    }
}