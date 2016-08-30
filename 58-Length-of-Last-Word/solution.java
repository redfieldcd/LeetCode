public class Solution {
    public int lengthOfLastWord(String s) {
        String[] str = s.split(" ");
        if(str.length < 1) return 0;
        String word = str[str.length-1];
        
        return word.length();
    }
}