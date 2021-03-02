package exam;

public class leetcode211 {
	class TrieNode{
        private boolean isEnd;
        private TrieNode[] child;
        public TrieNode(){
            isEnd = false;
            child = new TrieNode[26];
        }
    }
    private TrieNode root;
    /** Initialize your data structure here. */
    public leetcode211() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            if(node.child[ch-'a']==null)
                node.child[ch-'a'] = new TrieNode();
            node = node.child[ch-'a'];
        }
        node.isEnd = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(word, root, 0);
    }
    
    private boolean match(String word, TrieNode node, int start){
        if(start == word.length())
            return node.isEnd;
        char ch = word.charAt(start);
        if(ch == '.'){
            for(int i = 0; i < 26;i++){
                if(node.child[i]!=null && match(word, node.child[i], start+1))
                    return true;
            }
            return false;
        }
        else{
            if(node.child[ch-'a']==null)
                return false;
            return match(word, node.child[ch-'a'], start+1);
        }
    }
}
