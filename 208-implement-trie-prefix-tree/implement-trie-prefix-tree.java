class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        insertWord(root, word,0);
    }
    
    public boolean search(String word) {
        return searchString(root, word, 0);
    }
    
    public boolean startsWith(String prefix) {
        return startsWithString(root, prefix, 0);
    }

    public boolean searchString(TrieNode currNode, String word, int wordIdx){
        if(wordIdx == word.length()){
            if(currNode.isWord == true){
                return true;
            }else {
                return false;
            }
        }

        char curr = word.charAt(wordIdx);
        Map<Character, TrieNode> currMap = currNode.children;
        if(!currMap.containsKey(curr)){
            return false;
        }
        return searchString(currMap.get(curr), word, wordIdx+1);
    }

    public boolean startsWithString(TrieNode currNode, String word, int wordIdx){
        if(wordIdx == word.length()){
                return true;    
        }

        char curr = word.charAt(wordIdx);
        Map<Character, TrieNode> currMap = currNode.children;
        if(!currMap.containsKey(curr)){
            return false;
        }
        return startsWithString(currMap.get(curr), word, wordIdx+1);
    }

    public void insertWord(TrieNode currNode, String word, int wordIdx){
        if(wordIdx == word.length()){
             currNode.isWord = true;
             return;
        }
        char curr = word.charAt(wordIdx);
        Map<Character, TrieNode> currMap = currNode.children;
        if(!currMap.containsKey(curr)){
            currMap.put(curr, new TrieNode());
        }
        insertWord(currMap.get(curr), word, wordIdx+1);
    }
}

class TrieNode{
    Map<Character, TrieNode> children;
    boolean isWord;

    public TrieNode(){
        children = new HashMap<>();
        isWord = false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */