class Solution {
    public boolean exist(char[][] board, String word) {
        //brute force method 
        int[][] visited = new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0)){
                    boolean isMatch = checkMatch(board,i,j,word,0,visited);
                    if(isMatch)return true;
                }
            }
        }

        return false;
    }


    private boolean checkMatch(char[][] board, int i, int j, String word, int idx, int[][] visited){
        
        if(idx == word.length())return true;

        if(i<0 || i>=board.length || j<0 || j>=board[0].length || visited[i][j] == 1) return false;
        //System.out.println(word.charAt(idx)+"   "+idx+" "+visited[i][j]);
        if(board[i][j] != word.charAt(idx))return false;
        visited[i][j] = 1;
        boolean down = checkMatch(board, i+1, j, word, idx+1, visited);
        boolean up = checkMatch(board, i-1, j, word, idx+1, visited);
        boolean right = checkMatch(board, i, j+1, word, idx+1, visited);
        boolean left = checkMatch(board, i, j-1, word, idx+1, visited);
        visited[i][j] = 0;

        return (down||up||right||left);

    }
}