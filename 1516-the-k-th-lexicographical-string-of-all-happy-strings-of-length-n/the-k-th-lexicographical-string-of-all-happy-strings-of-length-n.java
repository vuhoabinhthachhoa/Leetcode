class Solution {
    int k;

    public String backtrack(int n, String cur) {
        if (n == 0) {
            if (k == 1) {
                return cur;
            }
            k--;
            //System.out.println(cur);
            return "";
        }
        char lastChar = cur.charAt(cur.length() - 1);
        if (lastChar == 'a') {
            String res1 = backtrack(n - 1, cur + 'b');
            if (!res1.isEmpty()) return res1;
            String res2 = backtrack(n - 1, cur + 'c');
            if (!res2.isEmpty()) return res2;
        } else if (lastChar == 'b') {
            String res1 = backtrack(n - 1, cur + 'a');
            if (!res1.isEmpty()) return res1;
            String res2 = backtrack(n - 1, cur + 'c');
            if (!res2.isEmpty()) return res2;
        } else {
            String res1 = backtrack(n - 1, cur + 'a');
            if (!res1.isEmpty()) return res1;
            String res2 = backtrack(n - 1, cur + 'b');
            if (!res2.isEmpty()) return res2;
        }
        return "";
    }

    public String getHappyString(int n, int inputK) {
        k = inputK;
        String res1 = backtrack(n - 1, "a");
        if (!res1.isEmpty()) return res1;
        String res2 = backtrack(n - 1, "b");
        if (!res2.isEmpty()) return res2;
        return backtrack(n - 1, "c");
    }
}