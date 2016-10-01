/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
//给出了root,顺着root找,如果root的大小比两个都大，那么，LCA在
//左子树，如果root的大小比两个都小,那么LCA在右子树
// public class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         if(root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
//         if(root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
//         return root;
//     }
// }
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(true){
          if((root.val-p.val)*(root.val-q.val) <= 0) return root;
          root = p.val < root.val ? root.left : root.right;
        }
    }
}
