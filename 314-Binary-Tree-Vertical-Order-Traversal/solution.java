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
    int min = 0, max = 0;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList();
        if(root == null) return res;
        computeRange(root, 0);
        for(int i = min; i <= max; i++) res.add(new LinkedList());
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Queue<Integer> idx = new LinkedList<Integer>();
        q.offer(root);
        idx.offer(-min);

        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            int i = idx.poll();
            res.get(i).add(node.val);
            
            if(node.left != null) {
                q.offer(node.left);
                idx.offer(i - 1);
            }
            
            if(node.right != null) {
                q.offer(node.right);
                idx.offer(i + 1);
            }
        }
        return res;
    }
    
    public void computeRange(TreeNode root, int idx) {
        if(root == null) return;
        min = Math.min(min, idx);
        max = Math.max(max, idx);
        computeRange(root.left, idx - 1);
        computeRange(root.right, idx + 1);
    }
}