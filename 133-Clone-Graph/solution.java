/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
 
//  public class Solution {
//     public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
//         if (node == null) return null;
//         UndirectedGraphNode root = new UndirectedGraphNode(node.label);//复制根节点
//         Queue<UndirectedGraphNode> queue = new LinkedList<>();
//         Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
//         queue.offer(node);//queue放入根结点
//         map.put(node, root);//map放入根结点和它的复制结点
//         while (!queue.isEmpty()) {
//             UndirectedGraphNode cur = queue.poll();//取出queue中（同一层）的结点进行BFS
//             for (UndirectedGraphNode n: cur.neighbors) {
//                 //对没有复制过的结点进行复制，并将这个结点放入queue
//                 if (!map.containsKey(n)) {
//                     map.put(n, new UndirectedGraphNode(n.label));
//                     queue.offer(n);
//                 }
//                 //连接复制结点和复制neighbor结点
//                 map.get(cur).neighbors.add(map.get(n));
//             }
//         }
//         return root;
//     }
// }
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        Queue<UndirectedGraphNode> q = new LinkedList();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap();
        
        q.offer(node);
        map.put(node, root);
        
        while(!q.isEmpty()) {
            UndirectedGraphNode cur = q.poll();
            for(UndirectedGraphNode n: cur.neighbors) {
                if(!map.containsKey(n)) {
                    map.put(n, new UndirectedGraphNode(n.label));
                    q.offer(n);
                }
                
                map.get(cur).neighbors.add(map.get(n));
            }
        }
        
        return root;
    }
}