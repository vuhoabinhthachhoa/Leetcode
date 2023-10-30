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
    void inOrderTraversal(TreeNode* root, vector<int>& ds) {
	if (!root) return;
	inOrderTraversal(root->left, ds);
	ds.push_back(root->val);
	inOrderTraversal(root->right, ds);
}
bool isValidBST(TreeNode* root) {
	vector<int>ds;
	inOrderTraversal(root, ds);
	int n = ds.size() - 1;
	for (int i = 0; i < n; i++){
		if (ds[i] >= ds[i + 1]) return false;
	}
	return true;
}
};