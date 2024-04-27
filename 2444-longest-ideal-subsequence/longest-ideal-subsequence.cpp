class Solution {
public:
 int longestIdealString(string s, int k) {
    /*dp[c] means the length of the longest ideal subsequence
        ending with character c.*/
    vector<int> dp(26, 0);
    int res = 0;

    for (char c : s) {
        // string which end with character from c - k to c + k (string which are valid to add c)
        // therefore, the longest ideal string ending with character c is equal to the longest string among
        // those valid strings + 1.
        for (int i = c - k; i <= c + k; i++) {
            // valid character
            if (i - 'a' < 0 || i - 'a' >= 26) {
                continue;
            }
            dp[c - 'a'] = max(dp[i - 'a'], dp[c - 'a']);
        }
        dp[c - 'a']++;
        res = max(res, dp[c - 'a']);
    }

    return res;
}
};