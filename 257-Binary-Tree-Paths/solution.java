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
     public List<String> binaryTreePaths(TreeNode root) {
         Queue<TreeNode> nodes = new LinkedList();
         Queue<String> strs = new LinkedList();
         List<String> res = new LinkedList();
         
         if(root == null) return res;
         
         nodes.add(root);
         strs.add(Integer.toString(root.val));
         
         while(!nodes.isEmpty()) {
             TreeNode node = nodes.poll();
             if(node.left == null && node.right == null) {
                 res.add(strs.poll());
             } else {
                 String newstr = strs.poll();
                 if(node.left != null) {
                     nodes.offer(node.left);
                     strs.offer(newstr+ "->" + node.left.val);
                 }
                 
                 if(node.right != null) {
                     nodes.offer(node.right);
                     strs.offer(newstr + "->" + node.right.val);
                 }
             }
         }
         
         return res;
     }
 }
 //简单的二叉树遍历，分左右子树
// public class Solution {
//     List<String> list = new ArrayList<String>();
    
//     public List<String> binaryTreePaths(TreeNode root) {
        
//         if (root != null){
//             String s = "" + root.val;
//             findPaths(root, s);
//         }
        
//         return list;
//     }
    
    
//     public void findPaths(TreeNode root, String s) {
//         if(root.left == null && root.right == null) {
//             list.add(s);
//         } 
//         //左右子树是要分别考虑的，所以不能写elseif
//         if (root.left != null) {
//             findPaths(root.left, s+"->"+root.left.val);
//         } 
        
//         if (root.right != null) {
//             findPaths(root.right, s+"->"+root.right.val);
//         }
//     }
// }