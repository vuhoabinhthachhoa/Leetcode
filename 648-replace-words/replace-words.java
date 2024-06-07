class Solution {
     class TrieNode {
        TrieNode[] childNode;
        boolean wordEnd;

        TrieNode () {
            childNode = new TrieNode[26];
            wordEnd = false;
        }
    }

    class Trie {
        TrieNode root;
        Trie() {
            root = new TrieNode();
        }

        void insert(String key) {
            TrieNode curr = root;
            for(int i = 0 ; i < key.length() ; i++) {
                int ind = key.charAt(i) - 'a';
                if(curr.childNode[ind] == null) {
                    curr.childNode[ind] = new TrieNode();
                }
                curr =  curr.childNode[ind];
            }
            curr.wordEnd = true;
        }

        boolean search(String key) {
            TrieNode curr = root;
            for(int i = 0 ; i < key.length() ; i++) {
                int ind = key.charAt(i) - 'a';
                if(curr.childNode[ind] == null) {
                    return false;
                }
                curr =  curr.childNode[ind];
            }
            return curr.wordEnd;
        }

    }
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for(String word : dictionary) {
            trie.insert(word);
        }

        String[] words = sentence.split(" ");
        StringBuilder res = new StringBuilder();

        for(String word : words) {
            StringBuilder root = new StringBuilder();
            for(int i = 0; i < word.length()&&!trie.search(root.toString());i++) {
                root.append(word.charAt(i));
            }
            res.append(root);
            res.append(" ");
        }

        res.deleteCharAt(res.length()-1);
        return res.toString();
    }


}