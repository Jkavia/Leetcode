class Solution {
    public void setZeroes(int[][] matrix) {
        
        int rowlen = matrix.length;
        int collen = matrix[0].length;
        boolean firstZero = false;

        for(int i=0;i<rowlen;i++){
            if(matrix[i][0] == 0) firstZero = true;
            for(int j=1;j<collen;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] =0;
                    matrix[0][j] =0;
                }
            }
        }

        for(int i=rowlen-1;i>=0;i--){
            for(int j=collen-1;j>0;j--){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j]=0;
                }
            }
            if(firstZero)matrix[i][0] =0;
        }
    }
}