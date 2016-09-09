public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList();
        
        if(k > n) {
            return res;
        }
        List<Integer> path = new LinkedList();
        search(res, path, 1, n, k);
        
        return res;
    }
    
    public void search(List<List<Integer>> res, List<Integer> path, int start, int n, int k) {
        if(k == 0) {
            List<Integer> temp = new LinkedList(path);
            res.add(temp);
            return;
        }
        
        //i = start 保证了后面的数字一定比前面的数字要大
        for(int i = start; i <= n; i++) {
            path.add(i);
            search(res, path, i + 1, n, k-1);
            path.remove(path.size() - 1);
        }
    }
}