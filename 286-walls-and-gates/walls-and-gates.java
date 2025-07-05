class Solution {
    // we'll start from breadth first search at gates
    // and we'll proceed with incrementing counter and updating the cell values with that counter. 
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length ==0)return;

        Queue<int[]> que = new LinkedList<>();

        int row = rooms.length;
        int col = rooms[0].length;

        for(int i =0;i<row;i++){
            for(int j=0;j<col;j++){
                if(rooms[i][j] == 0) que.offer(new int[]{i,j});
            }
        }
        int count =0;
        while(!que.isEmpty()){
            count++;
            int size = que.size();
            for(int x=0;x<size;x++){
                int[] cell = que.poll();

                int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

                for(int[] dir: dirs){
                    int nrow = dir[0]+cell[0];
                    int ncol = dir[1]+cell[1];

                    if(nrow>= 0 && nrow<rooms.length && ncol>= 0 && ncol<rooms[0].length && rooms[nrow][ncol] == Integer.MAX_VALUE){
                        rooms[nrow][ncol] = Math.min(rooms[nrow][ncol], count);
                        que.offer(new int[]{nrow,ncol});
                    }
                }

            }
        }
    }
}