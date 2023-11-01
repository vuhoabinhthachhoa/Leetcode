class Solution {
public:
  vector<int> productExceptSelf(vector<int>& nums) {
	int n = nums.size();
	vector<int>res(n);
	res[0] = 1;
	for (int i = 1; i < n; i++) {
		res[i] = nums[i - 1] * res[i - 1];
	}
	// after above loop, res[i] is the product of all elements before i. (the res of first element is 1)
	int right = nums[n - 1];
	// in this loop, right is the product of all elements after i (the right of last element is 1)
	// so the final answer of each element (res[i]) equal to right * res[i] ( the product of all element before i multiple 
	// by the product of all element after i)
	for (int i = n - 2; i >= 0; i--) {
		res[i] = right * res[i];
		right = right * nums[i];
	}
	return res;
}
};