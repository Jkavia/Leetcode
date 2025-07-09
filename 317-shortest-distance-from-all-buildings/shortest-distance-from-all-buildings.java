class Solution {
    public int shortestDistance(int[][] grid) {
        // do bfs from each building 
        // find distance to that building at each cell, use queue for each level 
        // after calculating distance from all building, then run a loop for each of the 
        // cells that are able to access all the buildings, and keep updating the min. 
        int row = grid.length;
        int col = grid[0].length;
        int[][] distances = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    if(!bfsForBuilding(grid, i, j, distances)){
                        return -1;
                    }
                }
            }
        }
        int minDis = Integer.MAX_VALUE;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(distances[i][j]+" ");
                if(grid[i][j]!= 1 && grid[i][j]!=2 && grid[i][j]!=3){
                    minDis = Math.min(minDis, distances[i][j]);
                }
            }
            System.out.println();
        }

        return minDis==Integer.MAX_VALUE?-1:minDis;

    }

    public boolean bfsForBuilding(int[][] grid, int iInput, int jInput, int[][] distances) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int[][] directions = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        Queue<Cell> que = new LinkedList<>();

        que.add(new Cell(iInput, jInput));
        int distance = 1;
        while (!que.isEmpty()) {
            int size = que.size();

            for (int i = 0; i < size; i++) {
                Cell cell = que.poll();

                for (int[] dir : directions) {
                    int x = cell.x + dir[0];
                    int y = cell.y + dir[1];

                    if (x >= 0 && x < row && y >= 0 && y < col && grid[x][y] != 2 && !visited[x][y]) {
                        visited[x][y] = true;
                        if(grid[x][y] == 1){
                            // we'll just mark the cell as visited to be used later.
                            continue;
                        }
                        distances[x][y] += distance;
                        que.add(new Cell(x, y));
                    }
                }
            }
            distance++;
        }


        //we have couple of missing scenarios here that we need to cover 
        // first is we need to make sure that all the gates are reachable from all points 
        // otherwise there is no solution, so we need to add the gates to visited. 
        // other thing is we need to somehow account for the unvisited cells and skip counting them 
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if(!visited[i][j]){
                        if(grid[i][j] == 0){
                            grid[i][j] = 3;
                        }
                        if(grid[i][j] == 1) return false;
                    }
                }
            }

            return true;
    }
}

class Cell{
    int x;
    int y;

    public Cell(int a, int b){
        x=a;
        y=b;
    }
}