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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList();
        Queue<TreeNode> q = new LinkedList();
        if(root == null) return list;
        
        q.offer(root);
        
        int mark = 0;
        while(!q.isEmpty()) {
            LinkedList<Integer> temp = new LinkedList();
            int size = q.size();

            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if(mark%2 == 0) {
                   temp.add(node.val); 
                } else {
                   temp.add(0, node.val);
                }
                
                if(node.left != null) {
                    q.offer(node.left);
                }
                
                if(node.right != null) {
                    q.offer(node.right);
                }
            }
            list.add(temp);
            mark++;
        }
        return list;
    }
}