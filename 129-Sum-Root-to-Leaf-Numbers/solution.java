/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //二叉树遍历，在遍历的过程中将自身的数值加入到叶子节点中
public class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root != null) getSum(root);
        return sum;
    }
    
    public void getSum(TreeNode root) {
        if(root.left == null && root.right == null) {
            sum += root.val;
        }
        
        if(root.left != null) {
            root.left.val += root.val*10
            getSum(root.left);
        }
        
        if(root.right != null) {
            root.right.val += root.val*10;
            getSum(root.right);
        }
    }
}