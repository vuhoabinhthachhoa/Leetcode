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

    // Intuition: Once we find a pair of nodes that are not in order, we swap them and then start traversing the tree again from the mother root.
    // We repeat this process until the tree is valid.
    // The way how to find the pair of nodes that are not in order is the same as in Validate Binary Search Tree problem.
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