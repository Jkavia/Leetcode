class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {

        int rows = maze.length;
        int cols = maze[0].length;

        boolean[][] visited = new boolean[rows][cols];

        return dfs(maze, start[0], start[1], destination, visited);
    }


    public boolean dfs(int[][] maze, int x, int y, int[] destination, boolean[][] visited){

        if(x == destination[0] && y == destination[1])return true;

        if(visited[x][y])return false;

        visited[x][y] = true;

        return moveUntilWall(maze, x,y,1,0, destination, visited) || 
        moveUntilWall(maze, x,y,0,1, destination, visited) || 
        moveUntilWall(maze, x,y,-1,0, destination, visited) || 
        moveUntilWall(maze, x,y,0,-1, destination, visited);
    }

    public boolean moveUntilWall(int[][] maze, int r, int c, int rDir, int cDir, int[] destination, boolean[][] visited){

        while(r+rDir >=0 && r+rDir <= maze.length-1 && c+cDir >=0 && c+cDir <= maze[0].length-1 && maze[r+rDir][c+cDir] == 0){
            r = r+rDir;
            c = c+cDir;
        }

        return dfs(maze, r, c, destination, visited);
    }
}