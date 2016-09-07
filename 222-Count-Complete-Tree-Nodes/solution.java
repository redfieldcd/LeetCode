/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // running time O(n), space O(h)
// public class Solution {
//     public int countNodes(TreeNode root) {
//         return countNodes(root, -1, -1);
//     }
    
//     public int countNodes(TreeNode root, int left, int right) {
//         if(left == -1) {
//             left = 0;
//             TreeNode curr = root;
//             while(curr != null) {
//                 left++;
//                 curr = curr.left;
//             }
//         }
        
//         if(right == -1) {
//             right = 0;
//             TreeNode curr = root;
//             while(curr != null) {
//                 right++;
//                 curr = curr.right;
//             }
//         }
        
//         if(left == right) return (1 << left) - 1;
        
//         //搜索左边就要把右子树搜索的高度设置为-1， 搜索右边就要把左子树搜索的高度设置为-1
//         return 1 + countNodes(root.left, left - 1, - 1) + countNodes(root.right, - 1, right - 1);  
//     }
// }


//Iteration
public class Solution {
    public int countNodes(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        int num = 0;
        q.offer(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            num += size;
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if(node.left != null) {
                    q.offer(node.left);
                }
                
                if(node.right != null) {
                    q.offer(node.right);
                }
            }
        }
        
        return num;
    }
}
