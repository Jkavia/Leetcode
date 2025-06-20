class Solution {
    public int orangesRotting(int[][] grid) {
        // using queue and bfs, we track one iteration of rotten oranges at a time in queue
        // and then rot the neighbors and run the next iteration and so on.
        int totalOranges = 0;
        int rottenOranges = 0;
        Queue<int[]> que = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                int orange = grid[i][j];
                if(orange == 2){
                    totalOranges++;
                    rottenOranges++;
                    que.add(new int[]{i,j});
                }
                if(orange ==1){
                    totalOranges++;
                }
            }
        }

        if(totalOranges == rottenOranges)return 0;
        int time =0;
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

        while(!que.isEmpty()){
            if(totalOranges == rottenOranges)return time;
            int size = que.size();
        for(int a=0;a<size;a++){
            int[] coords = que.poll();
            for(int i=0;i<dirs.length;i++){
                int row = coords[0]+dirs[i][0];
                int col = coords[1]+dirs[i][1];

                if(row >= 0 && row < grid.length && col >=0 && col < grid[0].length && grid[row][col] == 1){
                    grid[row][col]=2;
                    rottenOranges++;
                    que.add(new int[]{row, col});
                }
            }
        }
        time++;
        }

        return -1;
    }


}