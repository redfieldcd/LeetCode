// BFS Time worst case O(n^2), Space worst case O(n^2), n is the length of s
// public class Solution {
//     public List<String> removeInvalidParentheses(String s) {
//         List<String> res = new LinkedList();
//         Queue<String> q = new LinkedList();
//         Set<String> isVisited = new HashSet();
        
//         if(s == null) return res;
//         q.offer(s);
//         isVisited.add(s);
        
//         boolean isFound = false;
//         while(!q.isEmpty()) {
//             String cur = q.poll();
//             if(isValid(cur)) {
//                 res.add(cur);
//                 isFound = true;
//             }
            
//             if(isFound) continue;
            
//             for(int i = 0; i < cur.length(); i++) {
//                 // only delete '(' or ')'
//                 if(cur.charAt(i) != '(' && cur.charAt(i) != ')') continue;
                
//                 String substr = cur.substring(0,i) + cur.substring(i+1);
//                 if(!isVisited.contains(substr)) {
//                     q.offer(substr);
//                     isVisited.add(substr);
//                 }
//             }
//         }
        
//         return res;
//     }
    
//     public boolean isValid(String s) {
//         int num = 0;
//         for(int i = 0; i < s.length(); i++) {
//             if(s.charAt(i) == '(') num++;
//             else if(s.charAt(i) == ')'){
//                 if (num == 0) return false; // right can't be greater then left
//                 num--;
//             }
//         }
        
//         return num == 0;
//     }
// }

// DFS

public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> res = new HashSet();
        int l = 0;
        int r = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') l++;
            else if(s.charAt(i) == ')') {
                if(l != 0) l--;
                else r++;
            }
        }
        search(res, s, 0, l, r, 0, new StringBuilder());
        return new ArrayList<String>(res);
    }
    
    public void search(Set<String> res, String s, int i, int l, int r, int open, StringBuilder sb) {
        if(i == s.length() && l == 0 && r == 0 && open == 0) {
           res.add(sb.toString());
           return;
        }
        
        if(i == s.length() || l < 0 || r < 0 || open < 0) return;
        
        char c = s.charAt(i);
        int len = sb.length();
        
        if(c == '(') {
            search(res, s, i+1, l - 1, r, open, sb);
            search(res, s, i+1, l, r, open + 1, sb.append(c));
        } else if(c == ')') {
            search(res, s, i+1, l, r - 1, open, sb);
            search(res, s, i+1, l, r, open - 1, sb.append(c));
        } else {
            search(res, s, i+1, l, r, open, sb.append(c));
        }
        
        sb.setLength(len);
    }
}