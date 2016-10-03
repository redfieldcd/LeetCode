public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new LinkedList();
        List<int[]> list = new LinedList();
        
        for(int[] b : buildings) {
            list.add(new int{b[0], -b[2]});
            list.add(new int{b[1], b[2]});
        }
        
        Collections.sort(list, new comparator(){
            int compare(int[] l1, int[] l2) {
                if(l1[0] != l2[0]) {
                   return l1[0] - l2[0]; 
                } else {
                   return l1[1] - l2[0];
                }
            }
        });
        
        Queue<Integer> q = new PriorityQueue(new comparator(){
            int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        });
        
        pq.offer(0);
        // prev用于记录上次keypoint的高度
        int prev = 0;
        for(int[] h:list) {
            // 将左顶点加入堆中
            if(h[1] < 0) {
                pq.offer(-h[1]);
            } else {
            // 将右顶点对应的左顶点移去
                pq.remove(h[1]);
            }
            int cur = pq.peek();
            // 如果堆的新顶部和上个keypoint高度不一样，则加入一个新的keypoint
            if(prev != cur) {
                result.add(new int[]{h[0], cur});
                prev = cur;
            }
        }
        return result;
    }
}