/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
 
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        Queue<UndirectedGraphNode> q = new LinkedList();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap();
        
        //Node是原来连接的图，root是新复制的图
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