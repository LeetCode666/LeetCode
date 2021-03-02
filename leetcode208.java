package exam;

public class leetcode208 {
	class TrieNode {
        private boolean isEnd;
        private TrieNode[] next;

        public TrieNode() {
            isEnd = false;
            next = new TrieNode[26];
        }
    }
    
    private TrieNode root;
    /** Initialize your data structure here. */
    public leetcode208() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            if(node.next[ch-'a'] == null){
                node.next[ch-'a'] = new TrieNode();
            }
            node = node.next[ch - 'a'];
        }
        node.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for(char ch: word.toCharArray()){
            node = node.next[ch - 'a'];
            if(node ==null)
                return false;
        }
        return node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(char ch: prefix.toCharArray()){
            node = node.next[ch - 'a'];
            if(node ==null)
                return false;
        }
        return true;
    }
}
