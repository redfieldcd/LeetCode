/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //简单的二叉树遍历，分左右子树
public class Solution {
    List<String> list = new ArrayList<String>();
    
    public List<String> binaryTreePaths(TreeNode root) {
        
        if (root != null){
            String s = "" + root.val;
            findPaths(root, s);
        }
        
        return list;
    }
    
    
    public void findPaths(TreeNode root, String s) {
        if(root.left == null && root.right == null) {
            list.add(s);
        } 
        //左右子树是要分别考虑的，所以不能写elseif
        if (root.left != null) {
            findPaths(root.left, s+"->"+root.left.val);
        } 
        
        if (root.right != null) {
            findPaths(root.right, s+"->"+root.right.val);
        }
    }
}