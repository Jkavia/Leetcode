class Solution {
    // Add non rotten neighbors to the set 
    public int orangesRotting(int[][] grid) {
        Queue<int[]> que = new LinkedList<>();

        int time =0;
        int totalOne =0;
        int curr =0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 2){
                    int[] cords = new int[]{i,j};
                    que.add(cords);
                }
                if(grid[i][j] == 1){
                    totalOne++;
                }
            }
        }
        // no unrotten oranges so return 0 time
        if(totalOne == 0)return 0;

        while(!que.isEmpty()){
            time++;
            int size = que.size();
            for(int i =0;i<size;i++){
                int[] cords = que.poll();
                int[][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
                for(int[] dir:directions){
                    int x = cords[0]+dir[0];
                    int y = cords[1]+dir[1];

                    if(x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y]==1){
                        grid[x][y]=2;
                        int[] temp = new int[]{x,y};
                        que.add(temp);
                        curr++;
                    }
                    if(curr == totalOne) return time;
                }
            }
        }

        return -1;
        
    }
}