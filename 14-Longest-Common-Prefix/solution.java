public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        String l = strs[0];
        for(int i = 1; i < strs.length; i++) {
            int j = 0;
            while(j < l.length() && j < strs[i].length()) {
                if(l.charAt(j) == strs[i].charAt(j)) {
                    j++;
                } else {
                    break;
                }
            }
            
            l = l.substring(0, j);
        }
        
        return l;
    }
}