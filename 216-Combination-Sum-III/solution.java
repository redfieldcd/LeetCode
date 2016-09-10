public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new LinkedList();
        List<Integer> path = new LinkedList();
        
        search(res, path, 1, k, n);
        return res;
    }
    
    public void search(List<List<Integer>> res, List<Integer> path, int index, int k, int n) {
        if(k == 0 && n == 0) {
            List<Integer> temp = new LinkedList(path);
            res.add(temp);
        }
        
        if(k < 0 || n < 0) {
            return;
        }
        
        // 最大的数字就是9
        for(int i = index; i <= 9; i++) {
            path.add(i);
            search(res, path, i + 1, k - 1, n - i);
            path.remove(path.size() - 1);
        }
    }
}