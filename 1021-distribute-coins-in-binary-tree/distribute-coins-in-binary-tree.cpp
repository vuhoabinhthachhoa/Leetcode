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
    int help(TreeNode* root, int& totalSteps) {
    
        if(!root) {
            return 0;
        }
        int left = help(root->left, totalSteps);
        int right = help(root->right, totalSteps);

        totalSteps += abs(left) + abs(right);

        return left + right + root->val - 1;
    }

    int distributeCoins(TreeNode* root) {
        int totalSteps = 0;
        help(root, totalSteps);
        return totalSteps;
    }
};