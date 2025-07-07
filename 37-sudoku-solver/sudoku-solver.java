class Solution {
    public void solveSudoku(char[][] board) {
        
        solve(board, 0,0);
    }

    public boolean solve(char[][] board, int row, int col){
        // if we have parsed all rows and cols
        if(row == board.length){
            return true;
        }

        // if we have parsed current layer of column, restart with new row.
        if(col == board[0].length){
            return solve(board, row+1,0);
        }

        // we want to skip past the existing numeric values
        if(board[row][col] != '.'){
            return solve(board, row, col+1);
        }

        for(char c = '1';c<='9';c++){

            if(checkValidity(board, row, col, c)){
                board[row][col] = c;
                if(solve(board, row,col+1)){
                    return true;
                }
                // reset after failure in backtrack 
                board[row][col] = '.';
            }
        }

        return false;

    }

    public boolean checkValidity(char[][] board, int row, int col, char val){

        for(int i=0;i<board.length;i++){
            if(board[row][i] == val || board[i][col] == val)return false;

            int boxCol = 3* (col/3) + i%3;
            int boxRow = 3* (row/3) + i/3;
            //System.out.println("boxCol: "+boxCol+" boxRow: "+boxRow+" row: "+row+" col: "+col+" i :"+i);

            if(board[boxRow][boxCol] == val)return false;
        }

        return true;
    }
}


// steps here 
// traverse through the matrix using a solve function 
// in this function traverse through each row and its cols recursively 
// at each layer check for "." and insert vals between '1' to '9' with validity function check 
// how ever as we progress we might come across situations where we picked up a wrong number 
// as in forward column that led to conflict 
// to counter this we'll return false and update that cell value back to "."
// and try with a different numeric value to see if that fixes the future placements. 

// now one key thing is the check for the existence of the number in box, 
// to do that calculation we use a clever trick 
// as we know that in each box row only changes two times with an increment of 1 
// but the column changes 8 times with resets to 0 for each new row. 
// to implement this we go ncol = 3* col/3 + i%3 (used mod as it resets to 0 on new row)
// nrow = 3* row/3 + i/3 (/ as it increment with each i+3 )