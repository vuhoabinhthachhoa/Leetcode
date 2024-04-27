/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    void findNodes(TreeNode* root, int k, int currDistance, vector<int>& res) {
    if (!root) return ;
    if (currDistance == k) {
        res.push_back(root->val);
        return;
    }

    findNodes(root->left, k, currDistance + 1, res);
    findNodes(root->right, k, currDistance + 1, res);
}

bool findTarget(TreeNode* root, stack<TreeNode*>&st, TreeNode* target) {
    if (!root) return false;
    
    if (root->val == target->val) {
        return true;
    }

    if (root->left) {
        st.push(root->left);
        bool left = findTarget(root->left, st, target);
        if (left) { return true; };
        st.pop();
    }
   
    if (root->right) {
        st.push(root->right);
        bool right = findTarget(root->right, st, target);
        if (right) { return true; }
        st.pop();
    }

    return false;

}

void moveUp(TreeNode* currNode, stack<TreeNode*> st, int k, int currDistance, vector<int>& res) {
    if (st.empty()) { return; };

    TreeNode* parent = st.top();
    st.pop();

    if (currDistance == k) {
        res.push_back(parent->val);
        return;
    }

    if (parent->left && parent->left->val == currNode->val) {
        findNodes(parent->right, k, currDistance + 1, res);
    }
    else {
        findNodes(parent->left, k, currDistance + 1, res);
    }

    moveUp(parent, st, k, currDistance + 1, res);

}


vector<int> distanceK(TreeNode* root, TreeNode* target, int k) {
    if (!root) { return {}; }

    stack<TreeNode*> st;
    st.push(root);
    
    bool isExistTarget = findTarget(root, st, target);
    if (!isExistTarget) { return {}; }
    
    vector<int>res;
    TreeNode* foundedTarget = st.top();
    st.pop();

    // move up and find nodes
    moveUp(foundedTarget, st, k, 1, res);
    // go down and find nodes
    findNodes(foundedTarget, k, 0, res);

    return res;
}

};