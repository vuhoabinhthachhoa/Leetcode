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
     public boolean findStartNode(TreeNode root, int startValue, Stack<TreeNode>path ) {
        if(root == null) {
            return false;
        }
        if(root.val == startValue) {
            return true;
        }

        if (root.left != null) {
            path.push(root.left);
            if(findStartNode(root.left, startValue, path)) {
                return true;
            }
            path.pop();
        }

        if (root.right != null) {
            path.push(root.right);
            if(findStartNode(root.right, startValue, path)) {
                return true;
            }
            path.pop();
        }

        return false;
    }

    public boolean findDown(TreeNode root, int destValue, StringBuilder path) {
        if(root == null) {
            return false;
        }
        if(root.val == destValue) {
            return true;
        }
        if(root.left != null) {
            path.append('L');
            if(findDown(root.left, destValue, path)) {
                return true;
            }
            path.deleteCharAt(path.length() - 1);
        }

        if(root.right != null) {
            path.append('R');
            if(findDown(root.right, destValue, path)) {
                return true;
            }
            path.deleteCharAt(path.length() - 1);
        }
        return false;
    }


    public String getDirections(TreeNode root, int startValue, int destValue) {
        // find the start Node
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        findStartNode(root, startValue, st);

        TreeNode startNode = st.pop();
        StringBuilder path = new StringBuilder();
        if(findDown(startNode, destValue, path)) {
            return path.toString();
        }
        path = new StringBuilder();

        // find up
        TreeNode curr = startNode;
        while(true) {
            TreeNode parent = st.pop();
            path.append('U');
            if(parent.val == destValue) {
                break;
            }
            if(parent.left != null && parent.left.val == curr.val) {
                path.append('R');
                if(findDown(parent.right, destValue, path)) {
                    break;
                }
                path.deleteCharAt(path.length() - 1);
            }
            else {
                path.append('L');
                if(findDown(parent.left, destValue, path)) {
                    break;
                }
                path.deleteCharAt(path.length() - 1);
            }
            curr = parent;
        }

        return path.toString();
    }
}