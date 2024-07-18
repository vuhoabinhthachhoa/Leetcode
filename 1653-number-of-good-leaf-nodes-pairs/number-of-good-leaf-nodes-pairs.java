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
    int help(TreeNode root, int[] mp, int distance) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            mp[0] = 1;
            return 0;
        }
        int left = help(root.left, mp, distance);
        // copy mp to leftLeafs
        int[] leftLeafs = new int[distance];
        for(int i = 0 ; i < distance ; i++) {
            leftLeafs[i] = mp[i];
        }
        // clear mp
        for(int i = 0 ; i < distance ; i++) {
            mp[i] = 0;
        }

        int right = help(root.right, mp, distance);
        int[] rightLeafs = new int[distance];
        for(int i = 0 ; i < distance ; i++) {
            rightLeafs[i] = mp[i];
        }

        mp[0] = 0;
        for(int i = 1 ; i < distance ; i++) {
            mp[i] = leftLeafs[i-1] + rightLeafs[i-1];
        }

        int currPairs = 0;

        // prefix sum rightLeafs
        for(int i = 1 ; i < distance ; i++) {
            rightLeafs[i] += rightLeafs[i-1];
        }

        for(int i = 0 ; i <= distance-2 ; i++) {
            currPairs += leftLeafs[i] * rightLeafs[distance - 2 - i];
        }

        return left + right + currPairs;
    }

    public int countPairs(TreeNode root, int distance) {
        int[] mp = new int [distance];
        return help(root, mp, distance);
    }
}