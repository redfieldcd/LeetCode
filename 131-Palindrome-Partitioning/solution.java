public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new LinkedList();
        List<String> path = new LinkedList();
        dfs(res, path, s, 0);
        return res;
    }
    
    public void dfs(List<List<String>> res, List<String> path, String s, int pos) {
        if(pos == s.length()) {
            System.out.println("here");
            List<String> temp = new LinkedList(path);
            res.add(temp);
            return;
        }
        
        // "=" 不要忘记
        for(int i = pos + 1; i <= s.length(); i++) {
            String pre = s.substring(pos, i);
            if(isPalindrome(pre)) {
                path.add(pre);
                dfs(res, path, s, i);
                path.remove(path.size() - 1);
            }
        }
    }
    
    public boolean isPalindrome(String s) {
        for(int i = 0; i < s.length() / 2; i++) {
            if(s.charAt(i) != s.charAt(s.length()-i-1)) {
                return false;
            }
        }
        return true;
    }
}