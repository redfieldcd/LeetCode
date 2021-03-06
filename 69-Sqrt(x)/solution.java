//边界条件比较复杂
public class Solution {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        
        long left = 0;
        long right = 1;
        
        while(right * right < x) {
            right = right * 2;
        }
        
        while(left<= right) {
            long mid = left + (right - left)/2;
            if(mid * mid > x) {
                right = mid - 1;
            } else {
                if((mid+1)*(mid+1) > x) {
                    return (int)mid;
                }
                left = mid + 1;
            }
        }
        
        return 0;
    }
}
