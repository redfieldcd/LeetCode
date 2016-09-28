// Running time O(n)
// Space O(n)
public class Solution {
    
    public boolean validTree(int n, int[][] edges) {
         final Set<Integer> set = new HashSet<>();
            for (int i = 0, len = edges.length; i < len; i++) {
                if (set.add(edges[i][0]) == false) {
                    set.remove(edges[i][0]);
                }
                if (set.add(edges[i][1]) == false) {
                    set.remove(edges[i][1]);
                }
                if (set.size() == 0) {
                    return false;
                }
            }
            return edges.length == n - 1;
    }
}