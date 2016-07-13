public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        
        while(set.add(n)) {
            while(n > 0) {
                remain = n % 10;
                sum += remain*remain;
                n = n / 10;
                
                if(n == 1) {
                    return true;
                }
            }
            
            n = sum;
        }
        
        return false;
    }
}