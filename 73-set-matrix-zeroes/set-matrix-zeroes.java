class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rowWithZero = new HashSet<>();
        Set<Integer> colWithZero = new HashSet<>();
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    rowWithZero.add(i);
                    colWithZero.add(j);
                }
            }
        }
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(rowWithZero.contains(i) || colWithZero.contains(j)){
                    matrix[i][j] =0;
                }
            }
        }

    }
}