class Solution {
    public int orangesRotting(int[][] grid) {
        int totoalOranges = 0;
        boolean wasNonRottenThere = false;
        // count total oranges to keep the track
        for(int[] row: grid){
            for(int orange: row){
                if(orange > 0)totoalOranges++;
                // check if there are even non rotten oranges in the pack
                if(orange == 1)wasNonRottenThere = true;
            }
        }
        if(!wasNonRottenThere){
            return 0;
        }

        int totalMinutes = 0;
        int orangesAfterRotting =0;

        while(wasNonRottenThere){
            wasNonRottenThere = false;
            orangesAfterRotting = 0;
            for(int i =0;i<grid.length;i++){
                for(int j =0;j<grid[0].length;j++){
                    int orange = grid[i][j];
                    if(orange == 2)orangesAfterRotting++;
                    if(orange == 1 && checkNeighbors(grid, i, j)){
                        grid[i][j] = -1;
                        }
                    }
                }

            for(int i =0;i<grid.length;i++){
                for(int j =0;j<grid[0].length;j++){
                    int orange = grid[i][j];
                    if(orange == -1){
                        grid[i][j] = 2;
                        wasNonRottenThere = true;
                        }
                    }
                }
            for(int i =0;i<grid.length;i++){
                for(int j =0;j<grid[0].length;j++){
                    //System.out.print(grid[i][j]+"  ");
                }
                //System.out.println();
            }

            //System.out.println();

                if(wasNonRottenThere)totalMinutes++;
        }

        if(totoalOranges != orangesAfterRotting){
            return -1;
        }else{
            return totalMinutes;
        }
    }

    public boolean checkNeighbors(int[][] grid, int row, int col){
        int up = (row -1 < 0)? 100: grid[row-1][col];
        int down = (row+1 > grid.length-1)? 100: grid[row+1][col];
        int left = (col -1 < 0)? 100: grid[row][col-1];
        int right = (col+1 > grid[0].length-1)? 100: grid[row][col+1];

        return (up == 2 || down == 2 || left == 2 || right == 2);
    }
}