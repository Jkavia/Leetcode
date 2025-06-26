/**
Lets try to understand this problem in terms area calculations 
[x x 0]
[x Y 0]
[0 0 0]
now to calcualte the area of upper right triange you can sum the area of upper XX and left XX and Y 
but that would make you count diagonal X twice so just subtract that from total area hence 
XX + XX + Y - X, and we can repeat this process over and over to find the area of whole square.

Now. once we have the area dp, then on request well just find the area of
row2,col2 and subtract row1,col2 and row2,col1 and then we'll need to add back the double subtracted diagonal area at row1,col1
 */

class NumMatrix {
    int[][] dp;
    int row,col;

    public NumMatrix(int[][] matrix) {
        row = matrix.length+1;
        col = matrix[0].length+1;
        dp = new int[row+1][col+1];
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1]+matrix[i-1][j-1] - dp[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int upperRegion = dp[row1][col2+1];
        int sideRegion = dp[row2+1][col1];
        int totalArea = dp[row2+1][col2+1];
        int commonArea = dp[row1][col1];

        return totalArea-(upperRegion+sideRegion)+commonArea;
    }
}



/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */