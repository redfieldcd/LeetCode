/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 // iteration, 把右子树的都入栈，如果有左子树，把它作为右字树，否者就从
 // 栈内取出元素作为右子树
public class Solution {
    public void flatten(TreeNode root) {
        Stack<TreeNode> s = new Stack<TreeNode>()；
        
        while(root != null && !s.isEmpty()) {
            if(root.right != null) {
                s.push(root.right);
            }
            
            if(root.left != null) {
                root.right = root.left;
                root.left = null;
            } else {
                TreeNode node = s.pop();
                root.right = node;
            }
            
            root = root.right;
        }
    }
}