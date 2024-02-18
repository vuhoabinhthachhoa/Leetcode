class Solution {
public:
int subarraySum(vector<int>& nums, int k) {
	// mp[i] = the number of times that prefixSum = i; 
	unordered_map<int, int> mp;
	int res = 0;
	// we set mp[0] as 1 because the initial value of the prefix sum is 0.
	// so whenever sum - k = 0, that subarray starts at index 0.
	mp[0] = 1;
	int sum = 0;

	for (int i = 0; i < nums.size(); i++) {
		sum += nums[i];
		res += mp[sum - k]; // if mp[sum - k] appears three times, we increase res by 3. ex: 1 4 0 4 2 4 7 (k = 3)
		mp[sum]++;
	}

	return res;
}

};