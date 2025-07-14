//this problem has two parts 
// one to check the possible crush zones and flag them
// second to gravitiate crush those zones by moving up two pointers for each column 
// one final part is to know when to stop, to mark that we'll use a flag that will tell us if we
// found any possible crush zones in current iteration or not. 
class Solution {
    public int[][] candyCrush(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        boolean needToGravivate = true;

        while (needToGravivate) {
            needToGravivate = false;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (board[i][j] != 0 && checkCrushZones(i, j, board)) {
                        needToGravivate = true;
                    }
                }
            }
            if (needToGravivate) {
                gravitate(board);
            }
        }

        return board;
    }


    public void gravitate(int[][] board){
        int row = board.length;
        int col = board[0].length;
        // we'll do the traversal in colum by column manner. last row to first row for each column

        for(int j=0;j<col;j++){
            //use two pointers to track negative and non negative for replacements.
            // p1 only moves when cell is positive 
            int p1 = row-1;
            for(int p2 = row-1;p2>=0;p2--){
                if(board[p2][j]>0){
                    board[p1][j] = board[p2][j];
                    p1--;
                }
            }

            //once we have reached the top of the column for p2, then whatever values remain for p1 to travel, we;ll mark them 0
            for(int i=p1;i>=0;i--){
                board[i][j] = 0;
            }
        }
    }

    public boolean checkCrushZones(int i, int j, int[][] board) {
        int row = board.length;
        int col = board[0].length;
        int val = Math.abs(board[i][j]);
        boolean ret = false;

        if (i + 2 <= row - 1) {
            if ((Math.abs(board[i + 1][j]) == val) && (Math.abs(board[i + 2][j]) == val)) {
                ret = true;
                board[i][j] = val * -1;
                board[i + 1][j] = val * -1;
                board[i + 2][j] = val * -1;
            }
        }

        if (j + 2 <= col - 1) {
            if ((Math.abs(board[i][j+1]) == val) && (Math.abs(board[i][j+2]) == val)) {
                ret = true;
                board[i][j] = val * -1;
                board[i][j+1] = val * -1;
                board[i][j+2] = val * -1;
            }
        }

        return ret;

    }
}
