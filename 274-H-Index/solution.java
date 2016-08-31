public class Solution {
    public int hIndex(int[] citations) {
        int H = 0;
        //O(NlogN)
        Arrays.sort(citations);
        for(int i = 0; i < citations.length; i++) {
            int h = Math.min(citations[i], citations.length - i);
            if(h > H) {
                H = h;
            }
        }
        return H;
    }
}