/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int closestValue(TreeNode root, double target) {
        int closest = root.val;
        while(root != null) {
            if(Math.abs(target - root.val) < Math.abs(target - closest)) {
                closest = root.val;
            }
            if(root.val > target) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return closest;
    }
}