class Solution {
    public int[][] candyCrush(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        boolean repeat = true;

        while(repeat){
            repeat = false;
            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    if(board[i][j]!= 0 && isCrushable(i,j,board)){
                        repeat = true;
                    }
                }
            }

            if(repeat){
                gravitate(board);
            }
        }

        return board;
    }


    public void gravitate(int[][] board){
        int row = board.length;
        int col = board[0].length;

        for(int c=0;c<col;c++){
            int rp1 = row-1;
            for(int rp2=row-1;rp2>=0;rp2--){
                if(board[rp2][c]>0){
                    board[rp1][c] = board[rp2][c];
                    rp1--;
                }
            }

            // set remaining to 0
            for(int i=rp1;i>=0;i--){
                board[i][c] =0;
            }
        }
    }


    public boolean isCrushable(int i,int j, int[][] board){
        int row = board.length;
        int col = board[0].length;
        int val = Math.abs(board[i][j]);
        boolean ret = false;

        if(i+2 <= row-1 && Math.abs(board[i+1][j])==val && Math.abs(board[i+2][j])==val){
            board[i][j] = val*-1;
            board[i+1][j] = val*-1;
            board[i+2][j] = val*-1;
            ret = true;
        }

        if(j+2 <= col-1 && Math.abs(board[i][j+1])==val && Math.abs(board[i][j+2])==val){
            board[i][j] = val*-1;
            board[i][j+1] = val*-1;
            board[i][j+2] = val*-1;
            ret = true;
        }

        return ret;
    }
}

// we'll solve this problem in two parts 
// first is to find the cruhsable zones and we'll make them -ve of current value (2 down, 2 right compare)
// next we'll check if there were any crushable zones then we'll call gravitate functions to move the cells 
// in column by column manner. 
// to run gravitate we'll use use two pointer approach where one pointer will keep moving and other will only move 
// if the position in positive number. 