class Solution {
public:
   int minOperations(vector<int>& nums, int k) {
    vector<int> oneCount(32, 0);
    for (auto it : nums) {
        for (int i = 0; i < 32; i++) {
            // check i th bit of it
            if ((it >> i) & 1) {
                oneCount[i]++;
            }
        }
    }

    int res = 0;
    for (int i = 0; i < 32; i++) {
        // if i th bit of k is 1
        if ((k >> i) & 1) {
            // If the number of 1 bits in the ith bit position of nums is even, we need to change it to odd
            if (oneCount[i] % 2 == 0) {
                res++;
            }
        }
        // if i th bit of k is 0
        else {
            // If the number of 1 bits in the ith bit position of nums is odd, we need to change it to even
            if (oneCount[i] % 2 == 1) {
                res++;
            }
        }
    }

    return res;
}
};