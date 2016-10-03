/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
 
 public class Solution {
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        if(root != null) q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeLinkNode node = q.poll();
                // 最后一个节点的next已经被初始为null，不用管它
                if(i < size - 1) {
                    TreeLinkNode next = q.peek();
                    node.next = next;
                }   
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
        }
    }
}
//  public class Solution {
//     //based on level order traversal
//     public void connect(TreeLinkNode root) {
//         TreeLinkNode head = null;
//         TreeLinkNode pre = null;
//         TreeLinkNode cur = root;
        
//         while(cur != null) {
//             while(cur != null) {
//                 if(cur.left != null) {
//                     if(pre != null) {
//                         pre.next = cur.left;
//                     } else {
//                         head = cur.left;
//                     }
//                     pre = cur.left;
//                 }
                
//                 if(cur.right != null) {
//                     if(pre != null) {
//                         pre.next = cur.right;
//                     } else {
//                         head = cur.right;
//                     }
//                     pre =cur.right;
//                 }
                
//                 cur = cur.next;
//             }
            
//             cur = head;
//             pre = null;
//             head = null;
//         }
        
//     }
// }
