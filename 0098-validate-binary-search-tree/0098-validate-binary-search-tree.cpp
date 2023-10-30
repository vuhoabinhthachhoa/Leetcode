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
 bool help(TreeNode* root, TreeNode* minNode = nullptr, TreeNode* maxNode = nullptr) {
	if (!root) return true;
	if (minNode && root->val <= minNode->val || maxNode && root->val >= maxNode->val)
		return false;
	// all elements of the left tree must be less than root->val (root-val is the maxNode of the left tree)
	// all elements of the right tree must be greater than root->val (root-val is the minNode of the right tree)
	return help(root->left, minNode, root) && help(root->right, root, maxNode);
}
bool isValidBST(TreeNode* root) {
	return help(root);
}
};