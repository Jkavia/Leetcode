class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        //traverse the matrix and keep track of left, right, upper, lower limit and adjust them after each line of traversal.

        List<Integer> retlist = new ArrayList<>();
        int left = 0, right = matrix[0].length-1, up =0, down = matrix.length-1;

        while(left<=right && up<=down){

            //left to right
            for(int i=left;i<=right;i++){
                retlist.add(matrix[up][i]);
            }
            up++;

            //up to down
            for(int i=up;i<=down;i++){
                retlist.add(matrix[i][right]);
            }
            right--;

            //right to left 
            if(up<=down){
            for(int i=right;i>=left;i--){
                retlist.add(matrix[down][i]);
            }
            down--;
            }

            //down to up
            if(left<=right){
            for(int i=down;i>=up;i--){
                retlist.add(matrix[i][left]);
            }
            left++; 
            }
        }

        return retlist;
    }
}