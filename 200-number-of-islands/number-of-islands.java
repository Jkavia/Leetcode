class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] == '1'){
                    dfs(i,j,grid);
                    count++;
                }
            }
        }

        return count;
    }

    public void dfs(int i, int j, char[][] grid){
        if(i<0 || i>= grid.length || j<0 || j>= grid[0].length || grid[i][j] != '1')return;

        grid[i][j] = 'X';
        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};

        for(int[] dir: directions){
            int x = i+dir[0];
            int y = j+dir[1];

            dfs(x,y,grid);
        }
    }
}


// every time you find a 1 in matrix 
// mark the all its neibors including itseld with a number like 2,3,4 etc as id 
// and increase the count
// repeat the step 1
// reset the id's to 1
// return the count 