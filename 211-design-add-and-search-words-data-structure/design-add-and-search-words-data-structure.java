class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        addWordToTrie(root, word, 0);
    }
    
    public boolean search(String word) {
        return searchForStringInTrie(root, word, 0);
    }

    public boolean searchForStringInTrie(TrieNode root, String word, int wordIdx){
        if(wordIdx == word.length()) return root.isWord;

        char curr = word.charAt(wordIdx);
        Map<Character, TrieNode> currMap = root.children;
        if(!currMap.containsKey(curr) && curr != '.')return false;
        boolean ret = false;
        if(curr == '.'){
            for(char c:currMap.keySet()){
                if(searchForStringInTrie(currMap.get(c), word, wordIdx+1)){
                    ret = true;
                    break;
                }
            }
        }else{
        ret = searchForStringInTrie(currMap.get(curr), word, wordIdx+1);
        }
        return ret;
    }

    public void addWordToTrie(TrieNode root, String word, int wordIdx){
        if(word.length() == wordIdx){
            root.isWord = true;
            return;
        }

        char curr = word.charAt(wordIdx);
        Map<Character, TrieNode> currMap = root.children;
        if(!currMap.containsKey(curr)){
            currMap.put(curr, new TrieNode());
        }
        addWordToTrie(currMap.get(curr),word, wordIdx+1);
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
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */