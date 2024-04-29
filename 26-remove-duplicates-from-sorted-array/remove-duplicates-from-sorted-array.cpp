class Solution {
public:
   // Intuition: we move all the unique value to the left of array
// j is used to keep track of the last index of the unique elements
// i is the current iterator
int removeDuplicates(vector<int>& nums) {
    int n = nums.size();
    int j = 1; // we do not need to consider about nums[0]

    for (int i = 1; i < n; i++) {
        if (nums[i] != nums[i - 1]) { // that means we've encountered a new unique element
            nums[j] = nums[i]; // we move this unique element to the end of the unique elements
            j++;
        }
    }
    
    return j;
}

};