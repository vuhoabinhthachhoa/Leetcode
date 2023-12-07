class Solution {
public:
  int findDuplicate(vector<int>& nums) {
    // after first step of both slow and fast
    // we need to consider after first step because if we consider
    // at the begin (slow and fast are equal to 0), the loop will not
    // work.
    int slow = nums[0];
	int fast = nums[nums[0]];

	// we can only apply this type of traversing in case the range of element from 1 to n.
	// in this type: we consider slow (fast) is the value of node and nums[slow] (nums[fast])
	// is the next node.
    // Please look at the illustration to understand better.
	while (slow != fast) {
		fast = nums[nums[fast]];
		slow = nums[slow];
	}

	int entry = 0;
	while (entry !=slow) {
		entry = nums[entry];
		slow = nums[slow];
	}

	return slow;
}
};