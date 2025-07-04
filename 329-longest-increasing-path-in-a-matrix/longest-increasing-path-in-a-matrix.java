class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        //so it seems like this is a problem of DP 
        // because if you parse one path from index i,j then you also end up finding the longest path for its
        // children too, and we dont want to repeat that process again and reuse that longest path 
        // value of its child in future calculations 
        // for that we will create another matrix with -1 in all boxes and do a recursive call until we break the 
        // rule of either reaching boundary or there is no more greater values nearby.
        // now one intersting thing is there might be two or four possible paths from each point and in that case we
        // want to save the maximum path value from that point, so run a for loop on all sides and save the max. 
        int row = matrix.length;
        int col = matrix[0].length;
        int longestSum = Integer.MIN_VALUE;
        int[][] dp = new int[row][col];
        //Set<int[]> visited = new HashSet<>();
        for(int i=0;i<row;i++){Arrays.fill(dp[i],-1);}

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){

                int pathSum = longestPathSumForBox(matrix, dp, new int[]{i, j});
                longestSum = Math.max(longestSum, pathSum);
            }
        }

        return longestSum;  
    }


    public int longestPathSumForBox(int[][] matrix, int[][] dp, int[] node){

        int r = node[0], c = node[1];

        if(dp[r][c] != -1)return dp[r][c];

        int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

        int maxPathNode = 1;
        //visited.add(node);
        for(int[] dir: dirs){
            int val = matrix[r][c];
            int nRow = r+dir[0];
            int nCol = c+dir[1];
            if(nRow>=0 && nRow<matrix.length && nCol>=0 && nCol<matrix[0].length && matrix[nRow][nCol]>val){
                node[0] = nRow;
                node[1] = nCol;
                int currPath = longestPathSumForBox(matrix, dp, node)+1;
                maxPathNode = Math.max(maxPathNode, currPath);
            }
        }
        dp[r][c] = maxPathNode;
        //visited.remove(node);

        return maxPathNode;
    }


}