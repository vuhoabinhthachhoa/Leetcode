class Solution {
       public boolean isPrefix(String s1, String s2) {
        // check if s1 contains s2 or not
        int n1 = s1.length();
        int n2 = s2.length();
        if(n2 > n1 ) return false;

        int i = 0;
        while(i < n2 && s1.charAt(i) == s2.charAt(i)) i++;
        if(i == n2) return true;
        return false;
    }

    public List<String> split(String s, char c) {
        int pos = 0;
        List<String> res = new ArrayList<>();
        for(int i = 0 ; i < s.length() ; i++) {
            if(s.charAt(i) == c) {
                res.add(s.substring(pos, i));
                pos = i + 1;
            }
        }
        res.add(s.substring(pos));
        return res;
    }

    public int isPrefixOfWord(String sentence, String searchWord) {
        List<String> words = split(sentence, ' ');
        int i = 1;
        for(String word : words) {
            if(isPrefix(word, searchWord)) return i;
            i++;
        }
        return -1;
    }
}