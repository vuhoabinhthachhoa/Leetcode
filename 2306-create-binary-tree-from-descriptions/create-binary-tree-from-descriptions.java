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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> mp = new HashMap<>();
        HashSet<Integer> childs = new HashSet<>();
        for(int i = 0 ; i < descriptions.length ; i++) {
            childs.add(descriptions[i][1]);
            TreeNode parent = mp.getOrDefault(descriptions[i][0], null);
            TreeNode child = mp.getOrDefault(descriptions[i][1], null);
            if(parent == null) {
                parent = new TreeNode(descriptions[i][0]);
                mp.put(descriptions[i][0], parent);
            }
            if(child == null) {
                child = new TreeNode(descriptions[i][1]);
                mp.put(descriptions[i][1], child);
            }
            if(descriptions[i][2] == 1) {
                parent.left = child;
            }
            else {
                parent.right = child;
            }
        }
        for (Map.Entry<Integer, TreeNode> entry : mp.entrySet()) {
            Integer key = entry.getKey();
            if(!childs.contains(key)){
                return entry.getValue();
            }
        }
        return null;
    }

}