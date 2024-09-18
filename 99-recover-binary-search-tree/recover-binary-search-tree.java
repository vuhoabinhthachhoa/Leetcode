/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
     TreeNode motherRoot = null;
    public void recoverTree(TreeNode root) {
        motherRoot = root;
        help(root, null, null);
    }
    void help(TreeNode root, TreeNode minNode, TreeNode maxNode) {
        if(root == null) {
            return;
        }
        if(minNode != null && root.val < minNode.val) {
            int temp = minNode.val;
            minNode.val = root.val;
            root.val = temp;
            help(motherRoot, null, null);
            return;
        }
        if(maxNode != null && root.val > maxNode.val) {
            int temp = maxNode.val;
            maxNode.val = root.val;
            root.val = temp;
            help(motherRoot, null, null);
            return;
        }
        help(root.left, minNode, root);
        help(root.right, root, maxNode);

    }
}