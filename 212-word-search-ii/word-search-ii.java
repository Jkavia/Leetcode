class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = createTrie(words);
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        int[][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        Set<String> set = new HashSet<>();

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                char c = board[i][j];
                if(trie.children[c-'a']!=null){
                    dfs(visited,directions,board,i,j,set,trie);
                }
            }
        }
        return new ArrayList<>(set);
    }

    public void dfs(boolean[][] visited,int[][] directions, char[][] board, int i, int j,Set<String> set, Trie trie){

        if(i<0 || i>=board.length || j<0 || j>=board[0].length || visited[i][j] || trie.children[board[i][j]-'a'] == null)return;
        // since last one wont have children that's why here only we check for child
        if(trie.children[board[i][j]-'a'].word != null){
            set.add(trie.children[board[i][j]-'a'].word);
        }

        visited[i][j] = true;
        Trie t = trie.children[board[i][j]-'a'];
        for(int[] dir: directions){
            int xdir = i+dir[0];
            int ydir = j+dir[1];
            dfs(visited, directions, board, xdir, ydir,set, t);
        }
        visited[i][j] = false;
    }

    public Trie createTrie(String[] words){
        Trie root = new Trie();

        for(String s: words){
            Trie p = root;
            for(char c: s.toCharArray()){
                int idx = c-'a';
                //check if this Trie node already has a child for this character
                if(p.children[idx]== null){
                    p.children[idx] = new Trie();
                }
                p = p.children[idx];
            }
            // assign the word to last node
            p.word = s;
        }
        return root;
    }
}

class Trie{
    Trie[] children = new Trie[26];
    String word;
}