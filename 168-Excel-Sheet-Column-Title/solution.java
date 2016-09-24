public class Solution {
    public String convertToTitle(int n) {
        String path = "";
        while(n != 0) {
            char r = (char)((n-1) % 26 + 65);
            n = (n-1) / 26;
            path = r + path;
        }
        
        return path;
    }
}