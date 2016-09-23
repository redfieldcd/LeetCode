public class WordDictionary {
    
    public class TrieNode {
        TrieNode[] children;
        boolean isLeaf = false;
        char c;
        
        public TrieNode() {
           children = new TrieNode[26]; 
        }
        public TrieNode(char c) {
            children = new TrieNode[26];
            this.c = c;
        }
    }
    
    TrieNode root = Tier();
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode pointer = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(pointer.children[c - 'a'] == null) {
                TrieNode node = new TrieNode(c);
                pointer.children[c - 'a'] = node;
                pointer = pointer.children[c - 'a'];
            } else {
                pointer = pointer.children[c - 'a'];
            }
        }
        pointer.isLeaf = ture;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        TrieNode pointer = root;
        return helper(word, 0, root);
    }
    
    public boolean helper(String word, int index, TrieNode pointer) {
        if(index = word.length()) {
            if(pointer.isLeaf) return true;
            else return false;
        }
        
        char c = word.charAt(index);
        if(c == '.') {
            for(int i = 0; i < 26; i++) {
                if(pointer.children[i] != null) {
                    return helper(word, index + 1, pointer.children[i]);
                } 
            }
        } else {
            if(pointer.children[c - 'a'] == null) {
                return false;
            } else {
                return helper(word, index + 1, pointer.children[c - 'a']);
            }
        }
        return false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");