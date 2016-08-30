public class Solution {
    public int mySqrt(int x) {
        long low = 0 , high = x / 2;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(mid * mid < x){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (int)high;
    }
}

// public class Solution {
//     public int mySqrt(int x) {
//         long left = 0, right = x / 2;
        
//         while(left<= right) {
//             long mid = left + (right - left)/2;
//             if(mid*mid >= x) {
//                 right = mid - 1;
//             } else {
//                 left = mid + 1;
//             }
//         }
//         return (int)right;
        
//     }
// }