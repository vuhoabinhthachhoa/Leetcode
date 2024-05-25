class Solution {
     List<String> possibilities = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        backtrack("", wordDict, s, "", 0);
        return possibilities;
    }

    void backtrack(String ds, List<String> wordDict, String s, String curr, int ind) {
        if(ind == s.length()) {
            possibilities.add(ds.trim());
            return;
        }
        for(int i = ind ; i < s.length() ; i++) {
            curr += s.charAt(i);
            if(wordDict.contains(curr)) {
                ds += " " + curr;
                backtrack(ds, wordDict, s, "", i+1);
                ds = ds.substring(0, ds.length()-curr.length()-1);
            }
        }
    }
}