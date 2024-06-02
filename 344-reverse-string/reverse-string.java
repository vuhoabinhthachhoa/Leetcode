class Solution {
    public void reverseString(char[] s) {
    int left = 0;
    int right = s.length - 1;

    while (left < right) {
        // Swap s[left] and s[right]
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;

        // Move towards the middle
        left++;
        right--;
    }
}
}