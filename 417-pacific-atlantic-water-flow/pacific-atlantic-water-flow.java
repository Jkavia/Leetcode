class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;

        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];

        // left and right
        for(int i=0;i<row;i++){
            dfs(i, 0, pacific,heights,row,col);
            dfs(i, col-1, atlantic,heights,row,col);
        }

        // up and down
        for(int j=0;j<col;j++){
            dfs(0, j, pacific,heights,row,col);
            dfs(row-1, j, atlantic,heights,row,col);
        }

        List<List<Integer>> ret = new ArrayList<>();

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(atlantic[i][j] && pacific[i][j]){
                    ret.add(Arrays.asList(i,j));
                }
            }
        }

        return ret;
    }


    public void dfs(int i, int j, boolean[][] visited, int[][] heights, int row, int col){
        visited[i][j] = true;
        int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

        for(int[] dir: dirs){
            int x = i+dir[0];
            int y = j+dir[1];

            if(x>=0 && x<row && y>=0 && y<col && !visited[x][y] && heights[i][j] <= heights[x][y]){
                dfs(x,y,visited,heights,row,col);
            }
        }
    }
}

// so we'll do dfs from top and bottom for pac and atla
// and then we'll do the same for left and right 
// so as we know that water can fall from higher plane to lower or same hegiht plane. 
// we'll look for the neighbors close to border cells that are higher or equal to that cell 
// that would tell us if the water can fall into that cell and then ventually into the ocean
// then we'll repeat the process for next neighboring cells in dfs fashion while maintiaing a visited 
// here we can see both visited 