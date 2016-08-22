public class Solution {
    //一定要考虑负数的时候
    public boolean isPalindrome(int x) {
        if(x < 0 ) return false;
        
        int origin = x;
        int reverse = 0;
        
        while(x > 0) {
            reverse *= 10;
            reverse += x % 10;
            x = x / 10;
        }
        
        return origin == reverse;
    }
}