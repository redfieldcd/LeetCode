//Time O(n)
//Space O(1)
public class Solution {
    public int strStr(String haystack, String needle) {
        int len = needle.length();
        int l = haystack.length();
        if(l < len) return -1;
        
        for(int i = 0; i <= l - len; i++) {
            if(haystack.substring(i, i+len).equals(needle)) {
                return i;
            }
        }
        
        return -1;
    }
}