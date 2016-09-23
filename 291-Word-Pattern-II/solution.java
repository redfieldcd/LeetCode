public class Solution {
    boolean res;
    Map<Character, String> map;
    Set<String> set;
    public boolean wordPatternMatch(String pattern, String str) {
        map = new HashMap();
        set = new HashSet();
        res = false;
        search(pattern, str, 0, 0);
        
        return res;
    }
    
    public void search(String pattern, String str, int a, int b) {
        if(a == pattern.length() && b == str.length()) {
            res = true;
            return;
        }
        
        if(a >= pattern.length() || b >= str.length()) {
            return;
        }
        
        char c = pattern.charAt(a);
        for(int i = b + 1; i <= str.length(); i++) {
            String subStr = str.substring(b, i);
            if(!map.containsKey(c) && !set.contains(subStr)) {
                map.put(c, subStr);
                set.add(subStr);
                search(pattern, str, a + 1, i);
                map.remove(c);
                set.remove(subStr);
            } else if(map.containsKey(c) && map.get(c).equals(subStr)) {
                search(pattern, str, a + 1, i);
            }
        }
    }
    
}