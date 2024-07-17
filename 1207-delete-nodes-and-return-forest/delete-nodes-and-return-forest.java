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
    void help(TreeNode root, boolean[] mp, List<TreeNode> res) {
        if(root == null) {
            return;
        }
        if(root.left != null) {
            help(root.left, mp, res);
            if(mp[root.left.val]) {
                root.left = null;
            }
            else if(mp[root.val]){
                res.add(root.left);
            }
        }
        if(root.right != null) {
            help(root.right, mp, res);
            if(mp[root.right.val]) {
                root.right = null;
            }
            else if(mp[root.val]){
                res.add(root.right);
            }
        }
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new ArrayList<>();
        boolean[] mp = new boolean[1001];
        for(int i = 0 ; i < to_delete.length ; i++) {
            mp[to_delete[i]] = true;
        }
        if(!mp[root.val]) {
            res.add(root);
        }
        help(root, mp, res);
        return res;
    } 
}