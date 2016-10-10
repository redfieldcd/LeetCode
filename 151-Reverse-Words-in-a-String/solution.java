public class Solution {
    public String reverseWords(String s) {
        String[] ss = s.split(" ");
        String res = "";
        for(int i = ss.length; i >=0; i--) {
            res += ss[i] + " ";
        }
        
        return res.trim();
    }
}