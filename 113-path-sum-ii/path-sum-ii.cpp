/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    void help(TreeNode* root, int targetSum, vector<int>ds, vector<vector<int>>& res) {
	if (!root) return;

	ds.push_back(root->val);
	targetSum -= root->val;

	if (!root->left && !root->right) {
		if (targetSum == 0) res.push_back(ds);
		return;
	}

	help(root->left, targetSum, ds, res);
	help(root->right, targetSum, ds, res);
}

vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
	vector<int>ds; 
	vector<vector<int>>res;

	help(root, targetSum, ds, res);
	return res;
}

};