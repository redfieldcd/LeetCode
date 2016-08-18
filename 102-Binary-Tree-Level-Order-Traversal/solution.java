/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // iteration, 用一个list存结果，用一个queue来存每一层的元素
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList();
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        if(root == null) return list;
        q.offer(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new LinkedList();
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if(node.left != null) {
                    q.offer(node.left);
                } 
                if(node.right != null) {
                    q.offer(node.right);
                }
                level.add(node.val);
            }
            list.add(level);
        }
        return list;
    }
}