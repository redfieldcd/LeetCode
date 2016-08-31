//sort数组
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

//binary search
//如果原来的数组是排好序的，就可以用binary search