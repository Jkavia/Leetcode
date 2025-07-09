    // for this question we need to do a bfs from each of the building 
    // note the cell distance from that building, and for new building we add new distance to exiting distance 
    // but there are few catches here that we need to monitor, one is keep a track of cells that were never reached
    // two keep the track of possiblity if any of the building is in unreachable spot. (has walls all around it)
    // to keep the track of unvisited cells we'll put a value "3" in grid for those 
    // and to handle the unvisitable building case we will track it in visited array and if it comes out as 
    // unvisited after whole bfs then we know its inaccesible and the solution is not possible for this problem 
class Solution {
    public int shortestDistance(int[][] grid) {
        if(grid == null || grid.length == 0) return -1;

        int row = grid.length;
        int col = grid[0].length;

        int[][] distances = new int[row][col];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == 1 && !bfs(i,j,grid, distances)){
                    return -1;
                }
            }        
        }

        int minDistance = Integer.MAX_VALUE;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                //if its not a wall/unreachable cell/building then calculate min
                if(grid[i][j] != 1 && grid[i][j] != 2 && grid[i][j] != 3){
                    minDistance = Math.min(minDistance, distances[i][j]);
                }
            }
        }

        //there might be a possibility that all cells are unreacheable, in that case return -1
        return minDistance == Integer.MAX_VALUE ? -1:minDistance;

    }

    //lets do the bfs algorithm
    public boolean bfs(int i, int j, int[][] grid, int[][] distances){
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int[][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int distance =1;

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{i,j});

        while(!que.isEmpty()){
            int size = que.size();

            for(int a =0;a<size;a++){
                int[] cell = que.poll();
                for(int[] direction: directions){
                    int x = cell[0]+direction[0];
                    int y = cell[1]+direction[1];

                    if(x >=0 && x < row && y>=0 && y<col && grid[x][y]!=2 && !visited[x][y]){
                        visited[x][y] = true;
                        if(grid[x][y] == 1)continue; // just want to mark gates as visited. 
                        distances[x][y] += distance;
                        que.add(new int[]{x,y});
                    }
                }
            }
            distance++;
        }

        for(int a=0;a<row;a++){
            for(int b=0;b<col;b++){
                if(!visited[a][b]){
                    if(grid[a][b]==0){
                        grid[a][b]=3;
                    }
                    if(grid[a][b]==1) return false;
                }
            }
        }

        return true;


    }



}