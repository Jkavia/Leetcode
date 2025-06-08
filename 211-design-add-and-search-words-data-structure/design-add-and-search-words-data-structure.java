class WordDictionary {
    TrieNode head;
    public WordDictionary() {
        head = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = head;
        for(char c: word.toCharArray()){
            if(!node.children.containsKey(c)){
                TrieNode child = new TrieNode();
                node.children.put(c, child);
            }
            TrieNode temp = node.children.get(c);
            node = temp;
        }
        node.isLastNode = true;
    }
    
    public boolean search(String word) {
        TrieNode node = head;
        if(searchHelper(node, word, 0)){
            return true;
        }
        return false;
    }

    private boolean searchHelper(TrieNode node, String word, int idx){

        if(idx == word.length()){
            return node.isLastNode;
        }
        if(node.children.isEmpty())return false;

        char curr = word.charAt(idx);

        if(curr == '.'){
            for(char c: node.children.keySet()){
                if(searchHelper(node.children.get(c), word, idx+1)){
                    return true;
                }
            }
        }
            if(!node.children.containsKey(curr))return false;

             return searchHelper(node.children.get(curr), word, idx+1);
    }
}

class TrieNode{
    Map<Character, TrieNode> children;
    boolean isLastNode;

    public TrieNode(){
        children = new HashMap<>();
        isLastNode = false;
    }

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */