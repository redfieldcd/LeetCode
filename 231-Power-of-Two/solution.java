public class Solution {
    public boolean isPowerOfTwo(int n) {
       if(n <= 0) return false;
       
       while(n != 0) {
           int r = n % 2;
           n = n / 2;
           if(n != 0 && r != 0) return false;
       } 
       
       return true;
    }
}