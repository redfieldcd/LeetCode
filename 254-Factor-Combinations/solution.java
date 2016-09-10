public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new LinkedList();
        List<Integer> path = new LinkedList();
        
        search(res, path, n, 2);
        
        return res;
    }
    
    public void search(List<List<Integer>> res, List<Integer> path, int n, int index) {
        if(n <= 1) {
            if(path.size() > 1) {
                List<Integer> temp = new LinkedList(path);
                res.add(temp);
            }
            return;
        }
        
        // i = index是为了remove duplicate
        for(int i = index; i <= n; i++) {
            if(n % i == 0) {
                path.add(i);
                search(res, path, n / i, i);
                path.remove(path.size() - 1);
            }
        }
    }
}