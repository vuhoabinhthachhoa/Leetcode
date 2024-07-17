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
// Idea: https://youtu.be/JegJNGcwtFg?si=J9dCw_xjmBlkRqO3
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        if(root == null) {
            return null;
        }
        if(root.val == p|| root.val == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null && right == null) {
            return null;
        }
        if(left != null && right != null) {
            return root;
        }
        if(left != null) {
            return left;
        }
        return right;
    }
    boolean findStartNode(TreeNode root, int startValue, StringBuilder path) {
        if(root.val == startValue) {
            return true;
        }
        if(root.left != null) {
            path.append('U');
            if(findStartNode(root.left, startValue, path)) {
                return true;
            }
            path.deleteCharAt(path.length() - 1);
        }
        if(root.right != null) {
            path.append('U');
            if(findStartNode(root.right, startValue, path)) {
                return true;
            }
            path.deleteCharAt(path.length() - 1);
        }

        return false;
    }

    boolean findDestNode(TreeNode root, int destValue, StringBuilder path) {
        if(root.val == destValue) {
            return true;
        }
        if(root.left != null) {
            path.append('L');
            if(findDestNode(root.left, destValue, path)) {
                return true;
            }
            path.deleteCharAt(path.length() - 1);
        }
        if(root.right != null) {
            path.append('R');
            if(findDestNode(root.right, destValue, path)) {
                return true;
            }
            path.deleteCharAt(path.length() - 1);
        }

        return false;
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        // find the lowest common ancestor
       TreeNode LCA = lowestCommonAncestor(root, startValue, destValue);

       StringBuilder path = new StringBuilder();
       findStartNode(LCA, startValue, path);
       findDestNode(LCA, destValue, path);
       return path.toString();
    }

}