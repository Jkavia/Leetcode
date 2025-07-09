// we need to use recursion here or dfs with backtracking to undo the incorrect placements 
// additionally we need to have a separate function to check if that insertion is valid as per the rules
// at that point of time. i.e. check row,col,box values against insertion
class Solution {
    public void solveSudoku(char[][] board) {
        // helper function to pass row,col for termination conditions.
        solve(0,0,board);
    }

    public boolean solve(int row, int col, char[][] board){

        //check if we have parsed all the rows. 
        if(row == board.length)return true;

        if(col == board[0].length){
            return solve(row+1, 0,board);
        }

        if(board[row][col] != '.'){
            //skip the already populated cells
            return solve(row, col+1,board);
        }

        // process the empty columns
        for(char a = '1';a<='9';a++){
            //check for validity of this a 
            if(isValid(a,row, col, board)){
                board[row][col] = a;
                //if we found valid solution then we'll return true else we'll backtrack and insert diff value
                if(solve(row, col+1, board)){
                    return true;
                }else{
                    board[row][col] = '.';
                }
            }
        }

        return false;
    }


    public boolean isValid(char c, int row, int col, char[][]board){

        for(int i=0;i<9;i++){
            if(board[row][i] == c || board[i][col] == c) return false;
            // when i =3,4,5 row =1, i=6,7,8 row =2 
            // now for row 0-2 base is 0, 3-5 base is 1, 6-8 base is 2
            int nRow = 3* (row/3) + i/3;
            int nCol = 3 * (col/3) + i%3;

            if(board[nRow][nCol] == c) return false;
        }

        return true;
    }


}