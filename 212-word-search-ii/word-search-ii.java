class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        int row = board.length;
        int col = board[0].length;
        Trie trie = createTrie(words);
        Set<String> set = new HashSet<>();
        boolean[][] visited = new boolean[row][col];
        int[][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                char c =board[i][j];
                if(trie.children[c-'a']!=null){
                    dfs(board, set, visited, directions, i, j, trie);
                }
            }
        }

        return new ArrayList<>(set);
        
    }

    public void dfs(char[][] board, Set<String> set, boolean[][] visited, int[][] directions, int i, int j, Trie trie){
        if(i<0 || i>= board.length || j<0 || j>=board[0].length || visited[i][j] || trie.children[board[i][j]-'a']== null)return;

        if(trie.children[board[i][j]-'a'].word != null){
            set.add(trie.children[board[i][j]-'a'].word);
        }
        visited[i][j] = true;
        trie = trie.children[board[i][j]-'a'];
        for(int[] dir:directions){
            int x = i+dir[0];
            int y = j+dir[1];
            dfs(board, set, visited, directions, x,y,trie);
        }
        visited[i][j] = false;
    }


    public Trie createTrie(String[] words){
        Trie root = new Trie();
        for(String s:words){
            Trie p = root;
            for(char c:s.toCharArray()){
                if(p.children[c-'a'] == null){
                    p.children[c-'a'] = new Trie();
                }
                p = p.children[c-'a'];
            }
            p.word = s;
        }

        return root;
    }
}
class Trie{
    Trie[] children = new Trie[26];
    String word;
}

//to solve this problem we need to do a dfs+backtracking+trie approach. 
// trie will store children and if a word ends there then a string value word. 
// each trie node contains all the letter that start from there. 
// to track these characters we'll use the alphabetical numbers c-'a' for 0-26 
// once we have a trie we will do dfs on all 4 directions i.e. up/down/left/right 
// we'll maintain a visited array to avoid duplicate checks and if we reach a node in trie
// that has the word value that means we successfully found a match so we add it. 