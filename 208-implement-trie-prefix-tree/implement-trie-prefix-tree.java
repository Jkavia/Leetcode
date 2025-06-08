class Trie {
TrieNode head;

    public Trie() {
        head = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = head;

        for(char c: word.toCharArray()){
            if(!node.children.containsKey(c)){
            TrieNode curr = new TrieNode();
            curr.value = c;
            node.children.put(c, curr);
            }
            TrieNode temp = node.children.get(c);
            node = temp;
        }

        node.isLastNode = true;
    }
    
    public boolean search(String word) {
        TrieNode node = head;

        for(char c: word.toCharArray()){
            if(!node.children.containsKey(c)){
                return false;
            }
            TrieNode temp = node.children.get(c);
            node = temp;
        }
        return node.isLastNode;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = head;

        for(char c: prefix.toCharArray()){
            if(!node.children.containsKey(c)){
                return false;
            }
            TrieNode temp = node.children.get(c);
            node = temp;
        }
        return true;
    }
}


class TrieNode {
    Map<Character,TrieNode> children;
    boolean isLastNode;
    char value;

    public TrieNode(){
        children = new HashMap<>();
        isLastNode = false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */