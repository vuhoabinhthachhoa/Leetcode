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
        // left = 2 -> we need to to move 2 coins from currNode to left node
        // left = -2 -> we need to to move 2 coins from left node to currNode 
        // the same as right
        int left = help(root->left, totalSteps);
        int right = help(root->right, totalSteps);

        totalSteps += abs(left) + abs(right);

        // returned value: if > 0 : it's the number of coins we need to move to the ancestor node
        //  if < 0 : it's the number of coins we need to move from the ancestor node to currNode
        return left + right + root->val - 1;
    }

    int distributeCoins(TreeNode* root) {
        int totalSteps = 0;
        help(root, totalSteps);
        return totalSteps;
    }
};