// BFS Time worst case O(n^2), Space worst case O(n^2), n is the length of s
public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new LinkedList();
        Queue<String> q = new LinkedList();
        Set<String> isVisited = new HashSet();
        
        if(s == null) return res;
        q.offer(s);
        isVisited.add(s);
        
        boolean isFound = false;
        while(!q.isEmpty()) {
            String cur = q.poll();
            if(isValid(cur)) {
                res.add(cur);
                isFound = true;
            }
            
            if(isFound) continue;
            
            for(int i = 0; i < cur.length(); i++) {
                // only delete '(' or ')'
                if(cur.charAt(i) != '(' && cur.charAt(i) != ')') continue;
                
                String substr = cur.substring(0,i) + cur.substring(i+1);
                if(!isVisited.contains(substr)) {
                    q.offer(substr);
                    isVisited.add(substr);
                }
            }
        }
        
        return res;
    }
    
    public boolean isValid(String s) {
        int num = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') num++;
            else if(s.charAt(i) == ')'){
                if (num == 0) return false; // right can't be greater then left
                num--;
            }
        }
        
        return num == 0;
    }
}