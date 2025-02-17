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

    public int isPrefixOfWord(String s, String searchWord) {
        int pos = 0;
        int k = 1;
        for(int i = 0 ; i < s.length() ; i++) {
            if(s.charAt(i) == ' ') {
                if(isPrefix(s.substring(pos, i), searchWord)) {
                    return k;
                }
                pos = i + 1;
                k++;
            }
        }
        if(isPrefix(s.substring(pos), searchWord)) {
            return k;
        }
        return -1;
    }
}