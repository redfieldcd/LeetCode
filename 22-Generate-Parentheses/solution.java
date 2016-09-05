// running time  O(n), stack space O(n)
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList();
        dfs(res, "", 0, 0, n);
        return res;
    }
    
    public void dfs(List<String> res, String path, int left, int right, int max) {
        if(path.length() == 2 * max) {
            res.add(path);
            return;
        }
        
        if(left < max) {
            dfs(res, path + "(", left + 1, right, max);
        }
        
        if(right < left) {
            dfs(res, path + ")", left, right + 1, max);
        }
    }
}