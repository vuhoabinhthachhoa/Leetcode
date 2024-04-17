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
    void help(TreeNode* root,priority_queue<std::string, std::vector<string>, std::greater<std::string>> &minHeap, std::string currentPath) {
        if(!root) return;
        currentPath.push_back(root->val + 'a');

        if(!root->left && !root->right) {
            reverse(currentPath.begin(), currentPath.end());
            minHeap.push(currentPath);
            return;
        }

        if(root->left) help(root->left, minHeap, currentPath);
        if(root->right) help(root->right, minHeap, currentPath);
    }    

    std::string smallestFromLeaf(TreeNode* root) {
        priority_queue<std::string, std::vector<string>, std::greater<std::string>>minHeap;
        string currentPath = "";
        help(root, minHeap, currentPath);

        return minHeap.top();
    }
};