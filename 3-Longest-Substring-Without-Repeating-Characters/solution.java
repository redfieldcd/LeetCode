//用一个queue去维护O(n), space: O(n)
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null) return 0; 
        int max = 0;
        Queue<Character> q = new LinkedList();
        for(int i = 0; i < s.length(); i++) {
            while(q.contains(s.charAt(i))) {
                q.poll();
            }
            
            q.offer(s.charAt(i));
            
            if(q.size() > max) {
                max = q.size();
            }
        }
        
        return max;
    }
}