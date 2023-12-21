class Solution {
public:
    int findMaxLength(vector<int>& nums) {
    // An unordered map is used to store the sum from the beginning of each index.
    unordered_map<int, int> mp;
    // when we encounter the sum = 0, that means the contiguous array from the beginning to curr indices is valid.
    // So, do it to make sure the sum = 0 has always been encountered, and the length of contiguous array is curr_indices - (-1).
    mp[0] = -1;

    int sum = 0;
    int n = nums.size();
    int maxLength = 0;

    for (int i = 0; i < n; i++) {
        if (nums[i] == 0) sum -= 1;
        else sum += 1;
        
        if (mp.count(sum)) maxLength = max(maxLength, i - mp[sum]);
        // If a sum is encountered at multiple positions, store the leftmost position 
        // (it is the first position where that sum is encountered.)
        else mp[sum] = i;
    }

    return maxLength;
}
};