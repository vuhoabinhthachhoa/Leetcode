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
    vector<int> rightSideView(TreeNode* root) {
    if (!root) return {};

    vector<int>res;
    queue<TreeNode*>q;

    q.push(root);
    while (!q.empty()) {
        // size of each level
        int size = q.size();
        
        // the right most node of each level is the only node we can see in the level. 
        TreeNode* rightMostNode = q.front();
        q.pop();
        res.push_back(rightMostNode->val);
        if (rightMostNode->right) q.push(rightMostNode->right);
        if (rightMostNode->left) q.push(rightMostNode->left);

        // traverse over the other nodes in the level.
        for (int i = 1; i < size; i++) {
            TreeNode* curr = q.front();
            q.pop();
            if (curr->right) q.push(curr->right);
            if (curr->left) q.push(curr->left);
        }
        
    }
    return res;
}

};