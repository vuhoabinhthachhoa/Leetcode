#include <string>
using namespace std;

class Solution {
public:
    string longestPalindrome(string s) {
        int n = s.length();
        int longest_palindrome_start = 0;
        int longest_palindrome_len = 1;

        for (int i = 0; i < n; ++i) {
            int right = i;
            // assume odd length:  bab
            // right is at a, this loop helps to ingnore a and move right to b
            // assume even length: baaaab
            // right is at the first s, this loop helps to ignore all consecutive a elements.
            // if we don't use this line:
            // if we set right = i, left = i -1. We can only consider palindromes with even length.
            // and if we set right = i+1, left = i -1. We can only consider palindromes with odd length.
            // Therefore, this line is essential.
            while (right < n && s[i] == s[right]) {
                right++;
            }

            int left = i - 1;
            while (left >= 0 && right < n && s[left] == s[right]) {
                left--;
                right++;
            }

            int palindrome_len = right - left - 1;
            if (palindrome_len > longest_palindrome_len) {
                longest_palindrome_len = palindrome_len;
                longest_palindrome_start = left + 1;
            }
        }

        return s.substr(longest_palindrome_start, longest_palindrome_len);
    }
};
