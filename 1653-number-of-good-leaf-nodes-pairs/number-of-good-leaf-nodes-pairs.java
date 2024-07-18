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
    // mp is used as a map to store the number of leaf nodes at each distance
    // the return value is the number of valid pairs
    int help(TreeNode root, int[] mp, int distance) {
        if(root == null) {
            return 0;
        }
        // if it is a leaf node, we set mp[0] to 1 like now there is a leaf node at distance 0
        if(root.left == null && root.right == null) {
            mp[0] = 1;
            return 0;
        }
        int left = help(root.left, mp, distance);

        // copy mp to leftMp
        int[] leftMp = new int[distance];
        for(int i = 0 ; i < distance ; i++) {
            leftMp[i] = mp[i];
        }
        // clear mp
        for(int i = 0 ; i < distance ; i++) {
            mp[i] = 0;
        }

        int right = help(root.right, mp, distance);
        // copy mp to rightMp
        int[] rightMp = new int[distance];
        for(int i = 0 ; i < distance ; i++) {
            rightMp[i] = mp[i];
        }

        // calculate the mp for the current node
        // mp[i] means the number of leaf nodes at distance i
        // as we the current node is one step further from the leaf nodes compared to its children nodes, we need to add 1 to the distance
        // for example if leftMp[0] = 1 and rightMp[0] = 1, then mp[1] = 1 + 1 = 2
        // because the current node is not a leaf node, so mp[0] always be 0
        mp[0] = 0;
        for(int i = 1 ; i < distance ; i++) {
            mp[i] = leftMp[i-1] + rightMp[i-1];
        }

        // match all the valid pairs
        int currPairs = 0;
        // do prefix sum on rightMp to calculate the number of leaf nodes that are at distance i or less than i on the right subtree
        for(int i = 1 ; i < distance ; i++) {
            rightMp[i] += rightMp[i-1];
        }
        // for each distance i on the left subtree, we need to find the number of leaf nodes on the right subtree
        // such that the sum of the distance of each pair is less than or equal to distance
        // from left subtree move up 1 step, then move down another 1 step to the right subtree, then
        // the sum of the distance is right distance + left distance + 2
        // therefore, right distance = distance - 2 - left distance
        for(int i = 0 ; i <= distance-2 ; i++) {
            currPairs += leftMp[i] * rightMp[distance - 2 - i];
        }

        // combine all the valid pairs from the left subtree, right subtree and the current node itself and return
        return left + right + currPairs;
    }

    public int countPairs(TreeNode root, int distance) {
        int[] mp = new int [distance];
        return help(root, mp, distance);
    }

}