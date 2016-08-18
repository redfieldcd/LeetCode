/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
 
 //做level order traversal
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        Queue<TreeLinkedNode> q = new LinkedList<TreeLinkedNode>();
        
        q.offer(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeLinkedNode node = q.poll();
                
                if(node.left != null) {
                    q.offer(node.left);
                } 
                
                if(node.right != null) {
                    q.offer(node.right);
                }
                // 最后一个节点的next已经被初始为null，不用管它
                if(i > size - 1) {
                    TreeLinkedNode next = q.peek();
                    node.next = next;
                }
            }
        }
        
        
    }
}