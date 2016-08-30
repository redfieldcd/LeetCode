public class Solution {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        
        int left = 0, right = x;
        
        while(left<= right) {
            long mid = left + (right - left)/2;
            if(mid*mid > x) {
                right = mid - 1;
            } else {
                if((mid+1)*(mid+1) > x) {
                    return mid;
                }
                left = mid + 1;
            }
        }
    }
}
public int sqrt(int x) {
    if (x == 0)
        return 0;
    int left = 1, right = Integer.MAX_VALUE;
    while (true) {
        int mid = left + (right - left)/2;
        if (mid > x/mid) {
            right = mid - 1;
        } else {
            if (mid + 1 > x/(mid + 1))
                return mid;
            left = mid + 1;
        }
    }
}