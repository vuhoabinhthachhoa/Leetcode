class Solution {
    List<List<String>> result = new ArrayList<>();
    boolean isPalindrome(String s) {
        int n =s.length();
        for(int i = 0 ;  i < n / 2 ; i ++) {
            if(s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }


    public List<List<String>> partition(String s) {
        backtrack(new ArrayList<>(), "", s, 0);
        return result;
    }

    void backtrack(List<String> ds, String curr, String s, int ind) {
        if(ind == s.length()) {
            if(curr.isEmpty()) {
                result.add(new ArrayList<>(ds));
            }
            return;
        }

        curr += s.charAt(ind);

        if(isPalindrome(curr)) {
            ds.add(curr);
            backtrack(ds, "", s, ind + 1);
            ds.removeLast();
        }
        backtrack(ds, curr, s, ind + 1);

    }
}