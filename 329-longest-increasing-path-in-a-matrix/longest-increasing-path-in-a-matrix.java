class Solution {
    int longestPath = Integer.MIN_VALUE;
    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int[][] dp = new int[row][col];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(dp[i][j]==0){
                    dfs(i,j,dp,matrix,directions);
                }
            }
        }

        return longestPath;
    }


    public int dfs(int row, int col, int[][] dp, int[][] matrix,int[][] directions){
        if(dp[row][col] != 0)return dp[row][col];

        int maxSumSide = 0;

        for(int[] dir:directions){
            int x = row+dir[0];
            int y = col+dir[1];

            if(x>=0 && x<matrix.length && y>=0 && y<matrix[0].length && matrix[row][col]<matrix[x][y]){
                int dist = dfs(x,y,dp,matrix,directions);
                maxSumSide = Math.max(maxSumSide, dist);
            }
        }

        dp[row][col] = maxSumSide+1;
        longestPath = Math.max(longestPath, dp[row][col]);
        return dp[row][col];
    }
}