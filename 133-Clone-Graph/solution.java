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
        if(root == null) return null;
        UndirectedGraphNode root = new UndirectedGraphNode(node);
        Queue<UndirectedGraphNode> q = new LinkedList();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap();
        
        q.offer(root);
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