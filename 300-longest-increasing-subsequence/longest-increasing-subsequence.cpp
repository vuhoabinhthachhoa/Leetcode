class Solution {
public:
/*
* When x < pre_num, we replace the smallest number >= x with x.
* We do this so that x becomes the smallest number among the ending numbers
* of subsequences of the same length from the point we start considering. This ensures that we
* can create the longest possible subsequence.
* For example: given nums = 0, 1, 0, 3, 2, 3.
* - Initially, pick 0 then pick 1, we have the sequence 0, 1.
* - Then when encountering 0, we replace it with x = 0 (because 0 is the smallest number >= x).
* - When encountering 3, pick 3, resulting in the sequence 0, 1, 3.
* - When encountering 2, we replace 3 with 2, resulting in the sequence 0, 1, 2 
(because both 0, 1, 3 and 0, 1, 2 have a length of 3 but the last element 2 < 3, so 0, 1, 2 
potentially forms a longer subsequence than 0, 1, 3).
* - Encounter 3, pick 3, resulting in 0, 1, 2, 3.
*
* Another example:
* - Suppose we have the sequence: 0, 2, 6, 8. Then if we encounter 3, we will replace 6 with 3 because
* 0, 2, 6 and 0, 2, 3 are two subsequences of the same length but 3 < 6, so if the next elements are 4, 5, 6,
* 0, 2, 3 can accommodate those numbers while 0, 2, 6 cannot.
*/

// search the position in sub of the smallest number which is larger than or equal to curr num.
int binarySearch(vector<int>& sub, int currNum) {
    int low = 0;
    int high = sub.size() - 1;

    while (low <= high) {
        int mid = low + (high - low) / 2;

        if (sub[mid] >= currNum) high = mid - 1;
        else low = mid + 1;
    }

    return low;
}

int lengthOfLIS(vector<int>& nums) {
    int n = nums.size();
    vector<int> sub;
    sub.push_back(nums[0]);

    for (int i = 1; i < n; i++ ) {
        if (nums[i] > sub.back()) {
            sub.push_back(nums[i]);
        }
        else sub[binarySearch(sub, nums[i])] = nums[i];
    }

    return sub.size();
}
};