class Solution {
    public void rotate(int[][] matrix) {
        int rowlen  = matrix.length;
        int collen = matrix[0].length;

        for(int row =0;row<rowlen/2;row++){
            for(int col =row;col<collen-1-row;col++){
                int val = matrix[row][col];
                int count =0;

                while(count < 4){
                    int nrow = col;
                    int ncol = collen-1-row;
                    int temp = matrix[nrow][ncol];
                    matrix[nrow][ncol] = val;
                    val = temp;
                    row = nrow;
                    col = ncol;
                    count++;
                }
            }
        }
    }
}
/** 
when you rotate the 
the row of the next postion becomes col of previous one  
and row becomes len -1-row

00 > 02

col = row(prev) 0
row = len-1-col(prev) 3-1-0
so 02

similary 
02 > 22
row1 = col0 = 2
col1 = len-1-row0 = 3-1-0 =2
22

now we need to make sure that we rotate only half of the rows 
and concetric metrix so col start with row no and goes upto len-1-row
**/