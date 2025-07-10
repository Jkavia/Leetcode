class Solution {
    public void wallsAndGates(int[][] rooms) {
        int maxVal = Integer.MAX_VALUE;
        int distance = 1;
        int row = rooms.length;
        int col = rooms[0].length;

        Queue<int[]> que = new LinkedList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                // if its a gate add it to the que.
                if(rooms[i][j] == 0){
                    que.add(new int[]{i,j});
                }
            }
        }

        while(!que.isEmpty()){
            int size = que.size();
            int[][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

            for(int a=0;a<size;a++){
                int[] cell = que.poll();

                for(int[] dir:directions){
                    int x = cell[0]+dir[0];
                    int y = cell[1]+dir[1];

                    if(x>=0 && x<row && y>=0 && y<col && rooms[x][y]!=0 && rooms[x][y]!=-1 && rooms[x][y]==maxVal){
                        rooms[x][y] = distance;
                        que.add(new int[]{x,y});
                    }
                }
            }
            distance++;
        }
    }
}

// we'll do a bfs from gates 
// to track the visited attribute we'll just perfrom a check for maxValue present if not update it
// we dont need to do a min on the cells since if a cell is already visited that means it was closer to the older gate than current one.