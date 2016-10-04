// Running time O(n)
// Space O(n)
// public class Solution {
//     public boolean validTree(int n, int[][] edges) {
//          final Set<Integer> set = new HashSet<>();
//             for (int i = 0, len = edges.length; i < len; i++) {
//                 if (set.add(edges[i][0]) == false) {
//                     set.remove(edges[i][0]);
//                 }
//                 if (set.add(edges[i][1]) == false) {
//                     set.remove(edges[i][1]);
//                 }
//                 if (set.size() == 0) {
//                     return false;
//                 }
//             }
//             return edges.length == n - 1;
//     }
// }

//Union-find
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] parent = new int[n];
        
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        for(int[] edge : edges) {
            int l = find(parent, edge[0]);
            int r = find(parent, edge[1]);
            if(l == r) return false;
            parent[r] = l;
        }
        
       return n - 1 == edges.length;
    }
    
    public int find(int[] parent, int a) {
        if(parent[a] != a) {
           parent[a] = find(parent, parent[a]); 
        }
        
        return parent[a];
    }
    
}