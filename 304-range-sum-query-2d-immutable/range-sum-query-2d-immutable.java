class NumMatrix {

    int[][] internalMatrix;
    int row,col;
    public NumMatrix(int[][] matrix) {
        row = matrix.length+1;
        col = matrix[0].length+1;
        internalMatrix = new int[row][col];
        //use dp sum the upper area and left area and main value and then subtract that upper corner that was
        // counted twice in upper and left.
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                internalMatrix[i][j] = 
                internalMatrix[i][j-1] + internalMatrix[i-1][j] + matrix[i-1][j-1] - internalMatrix[i-1][j-1];
            }
        }

    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int totalAreaToConsider = internalMatrix[row2+1][col2+1];
        //Area on upper and left side.
        int areaToSubtract = internalMatrix[row1][col2+1] + internalMatrix[row2+1][col1];
        // Since it was double subtracted
        int areaToAddAgain = internalMatrix[row1][col1];

        return totalAreaToConsider-areaToSubtract+areaToAddAgain;
    }
}
//lets say if every elemet is the sum of upper and left
// track total sum
//
/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */