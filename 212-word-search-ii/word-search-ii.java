class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n = board[0].length;
        TrieNode root = createTrie(words);
        boolean[][] visited = new boolean[m][n];
        List<String> ret = new ArrayList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                findWordsHelper(root, visited, ret, i, j, board);
            }
        }

        return ret;
    }
    //traverse the array and try to find the words in trie based on this traversal 
    public void findWordsHelper(TrieNode root,boolean[][] visited,List<String> ret,int m, int n,char[][] board){
        if(m<0 || n<0 || m>=board.length || n>=board[0].length || visited[m][n] || root.children[board[m][n]-'a']==null)
        {
            return;
        }

        visited[m][n] = true;

        TrieNode curr = root.children[board[m][n]-'a'];
        if(curr.word != null){
            ret.add(curr.word);
            curr.word = null;
        }

        findWordsHelper(curr, visited, ret, m+1, n, board);
        findWordsHelper(curr, visited, ret, m, n+1, board);
        findWordsHelper(curr, visited, ret, m-1, n, board);
        findWordsHelper(curr, visited, ret, m, n-1, board);

        visited[m][n] = false;
    }




    public TrieNode createTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String s: words){
            TrieNode node = root;
            for(char c: s.toCharArray()){
                if(node.children[c-'a'] == null){
                    node.children[c-'a'] = new TrieNode();
                }
                node = node.children[c-'a'];
            }
            node.word = s; 
        }

        return root;
    }
}

class TrieNode{
    TrieNode[] children = new TrieNode[26];
    String word;
}

// create a trie with childern as each alphabet so size 26 
// 