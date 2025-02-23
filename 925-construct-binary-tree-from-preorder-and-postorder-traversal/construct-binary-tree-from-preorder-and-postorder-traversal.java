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
    Map<Integer, Integer> map = new HashMap<>();
    int leftEdge = 0;
    int ind = 0;

    public TreeNode buildTree(int[] preorder, int[] postorder) {
        if(ind == preorder.length) return null;
        int curVal = preorder[ind];
        TreeNode root = new TreeNode(curVal);
        ind++;
        if(map.get(curVal) == leftEdge) {
            leftEdge++;
            return root;
        }
        root.left = buildTree( preorder, postorder);
        if(map.get(curVal) == leftEdge) {
            leftEdge++;
            return root;
        }
        root.right = buildTree(preorder, postorder);
        if(map.get(curVal) == leftEdge) {
            leftEdge++;
        }
        return root;
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        for(int i = 0; i < n; i++) {
            map.put(postorder[i], i);
        }
        return buildTree(preorder, postorder);
    }
}
