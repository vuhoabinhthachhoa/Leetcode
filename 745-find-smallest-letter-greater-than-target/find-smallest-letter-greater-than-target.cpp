class Solution {
public:
    char nextGreatestLetter(vector<char>& letters, char target) {
    int l = 0;
    int r = letters.size() - 1;
    while (l <= r) {
        int mid = (l + r) / 2;
        if (letters[mid] > target) r = mid - 1;
        else l = mid + 1;
    }
    if(l > letters.size() - 1 || l < 0) {
        return letters[0];
    }
    return letters[l];
}
};