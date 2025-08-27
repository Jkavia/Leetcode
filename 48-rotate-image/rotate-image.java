class Solution {
    public void rotate(int[][] matrix) {
        
        int len = matrix.length;
        int collen = matrix[0].length;

        for(int row =0;row <= len/2;row++){
            for(int col = row; col < collen-1-row; col++){
                int val = matrix[row][col];
                int count =0;
                while(count < 4){
                    int nrow = col;
                    int ncol = collen-1-row;
                    int temp = matrix[nrow][ncol];
                    matrix[nrow][ncol] = val;
                    val = temp;
                    col = ncol;
                    row = nrow;
                    count++;
                }
            }
        }

    }
}

// row = col 
// col = len -1-row

// 00 > 02 row = col = 0 & col = 2-0 = 2
// 02 > 22 row = col = 2 & col = 2-0 = 2