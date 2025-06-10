class Solution {
    public void rotate(int[][] matrix) {
        
        for(int row =0;row<matrix.length/2;row++){
            for(int col =row;col<matrix.length-1-row;col++){
            int count =0;
            int val = matrix[row][col];
            while(count < 4){
                int tempr = col;
                int tempc = matrix.length-1-row;
                row = tempr;
                col = tempc;
                int tempVal = matrix[row][col];
                matrix[row][col] = val;
                val = tempVal;
                count++;
            }
            }
        }
    }
}