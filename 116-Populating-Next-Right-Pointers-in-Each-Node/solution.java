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
        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        if(root!=null) q.offer(root);
        while(!q.isEmpty()){
            //记录本层节点的个数
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeLinkNode curr = q.poll();
                //最后一个节点的next是null，不做处理
                if(i < size - 1){
                    TreeLinkNode next = q.peek();
                    curr.next = next;
                }
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }
        }
    }
}