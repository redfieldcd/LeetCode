public class WordDictionary {
    class TrieNode{
        TrieNode[] children;
        char c;
        boolean isLeaf;
        public TrieNode() {
            this.children = new TrieNode[26];
        }
        
        public TrieNode(char c) {
            this.children = new TrieNode[26];
            this.c = c;
        }
    }
    
    TrieNode root = new TrieNode();
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode pointer = root;
        
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(pointer.children[c - 'a'] != null) {
                pointer = pointer.children[c - 'a'];
            } else {
                TrieNode node = new TrieNode(c);
                pointer.children[c - 'a'] = node;
                pointer = pointer.children[c - 'a'];
            }
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if(word == null || word.length() == 0) return false;
        return dfs(word,root,0);
    }
    
    public boolean dfs(String word, TrieNode pointer, int idx) {
        if(idx == word.length()) {
            if(pointer.isLeaf) return true;
            else  return false;
        } 
        
        char c = word.charAt(idx);
        for(int i = idx; i < word.length(); i++) {
            if(c == '.') {
                for(int i = 0; i < 26; i++) {
                    if(pointer.children[i] != null) {
                        if(dfs(word, pointer.children[i], idx + 1)) {
                            return true;
                        }
                    }
                }
            } else {
                if(pointer[c - 'a'] != null) {
                    return dfs(word, pointer.children[i], idx + 1);
                } else {
                    return false;
                }
            }
        }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");