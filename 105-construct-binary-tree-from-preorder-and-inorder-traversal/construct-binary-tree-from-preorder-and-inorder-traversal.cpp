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
 TreeNode* help(vector<int> &preorder, int pre_start, vector<int> &inorder, int in_start, int in_end, unordered_map<int, int> &mp) {
	
	if (in_start > in_end) {
		return nullptr;
	}

	TreeNode* newNode = new TreeNode(preorder[pre_start]);

	if (in_start == in_end) {
		return newNode;
	}

	// the position of current TreeNode in inorder vector.
	int curr_pos = mp[newNode->val]; 

	newNode->left = help(preorder, pre_start + 1, inorder, in_start, curr_pos - 1, mp);
	newNode->right = help(preorder, pre_start + (curr_pos - in_start + 1), inorder, curr_pos + 1, in_end, mp);

	return newNode;
}

TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {

	// store the position of all elements in inorder vector.
	unordered_map<int, int> mp;
	for (int i = 0; i < inorder.size(); i++) {
		mp[inorder[i]] = i;
	}

	return help(preorder, 0, inorder, 0, inorder.size() - 1, mp);
}
};