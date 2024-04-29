class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
    int n = nums.size();
    unordered_map<int, bool> isExist;

    for (int i = 0; i < n; i++) {
        if (isExist[nums[i]]) {
            nums.erase(nums.begin() + i);
            i--;
            n--;
        }
        else {
            isExist[nums[i]] = true;
        }
    }

    return nums.size();
}
};