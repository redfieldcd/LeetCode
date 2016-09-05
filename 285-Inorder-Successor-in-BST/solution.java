/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // 第一步： 把p之前的都存入栈
 // 第二步： 如果目标点的右侧有孩子就一直找到最左边的那个，
 //          如果没有就从栈里面一个一个找，一定要注意栈会不会空
 //          如果空了还没有找到，说明这个目标点的值是这棵树种最大的
// public class Solution {
//     public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
//         TreeNode curr = root;
//         Stack<TreeNode> s = new Stack<TreeNode>();
        
//         while(curr != p) {
//             s.push(curr);
//             if(curr.val > p.val) {
//                 curr = curr.left;
//             } else {
//                 curr = curr.right;
//             }
//         }
//         if(p.right != null) {
//             curr = p.right;
//             while(curr.left != null) {
//                 curr = curr.left;
//             }
//             return curr;
//         } else {
//             while(!s.isEmpty() && s.peek().val < p.val) {
//                 s.pop();
//             }
//             return s.isEmpty() ? null: s.pop();
//         }
//     }
// }

//recursion
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null) return null;
        
        if(root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode left = inorderSuccessor(root.left, p);
            return left == null ? root:left;
        }
    }
}

