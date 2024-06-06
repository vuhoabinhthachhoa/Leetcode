class Solution {
   public int appendCharacters(String s, String t) {
        int i = 0;
        for(char c : s.toCharArray()) {
            if(c == t.charAt(i)) {
                i++;
            }
            if(i == t.length()) {
                return 0;
            }
        }
        return t.length() - i;
    }
}