class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
	vector<vector<int>>res;
	sort(nums.begin(), nums.end());
	int n = nums.size();
	int i = 0;
	while (i <= n-3) {
		int j = i + 1;
		int k = n - 1;
		int temp;
		while (j < k) {
			int curr_sum = nums[i] + nums[j] + nums[k];
			if (curr_sum == 0) {
				res.push_back({ nums[i], nums[j], nums[k] });
				temp = nums[k];
				while ( k>=2 && temp == nums[k]) k--;
				temp = nums[j];
				while (j<=n-2 && temp == nums[j]) j++;
			}
			else if (curr_sum > 0) {
				temp = nums[k];
				while (k >= 2 && temp == nums[k]) k--;
			}
			else {
				temp = nums[j];
				while (j <= n - 2 && temp == nums[j]) j++;
			}
		}
		temp = nums[i];
		while (i < n-2 && temp == nums[i] ) i++;
	}
	return res;
}
};