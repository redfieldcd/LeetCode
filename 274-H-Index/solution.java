//sort数组
// public class Solution {
//     public int hIndex(int[] citations) {
//         int H = 0;
//         //O(NlogN)
//         Arrays.sort(citations);
//         for(int i = 0; i < citations.length; i++) {
//             int h = Math.min(citations[i], citations.length - i);
//             if(h > H) {
//                 H = h;
//             }
//         }
//         return H;
//     }
// }

//不对数组进行排序
public class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        if(n == 0) return 0;
        
        int[] stat = new int[n+1];
        int sum = 0;
        
        for(int i = 0; i < n; i++) {
            stat[citations[i] <= n ? citations[i] : n] += 1;
        }
        
        for(int i = n; i > 0; i--) {
            sum += stat[i];
            if(sum >= i) {
                return i;
            }
        }
        
        return 0;
    }
}
//binary search
//如果原来的数组是排好序的，就可以用binary search