public class Solution {
    public int hIndex(int[] citations) {
         int n = citations.length;
         if(n == 0) return 0;
         int min = 0;
         int max = n - 1;
         
         while(min <= max) {
             int mid = min + (max - min) / 2;
             if(citations[mid] == n - mid) return n - mid;
             if(citations[mid] < n - mid) {
                 min = mid + 1;
             } else {
                 max = mid - 1;
             }
         }
         
         return n - min;
    }
}