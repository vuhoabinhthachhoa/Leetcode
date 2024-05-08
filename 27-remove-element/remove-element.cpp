class Solution {
public:
   int removeElement(vector<int>& nums, int val) {
    int n = nums.size();

    int i = 0;
    while (i < n && nums[i] != val) {
        i++;
    }

    int left = i;
    int right = i + 1;
    for (; right < n; right++) {
        if (nums[right] != val) {
            swap(nums[right], nums[left]);
            left++;
        }
    }

    return left;
}
};