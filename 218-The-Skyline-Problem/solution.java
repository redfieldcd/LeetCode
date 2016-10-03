public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new LinkedList();
        List<int[]> list = new LinkedList();
        
        for(int[] b : buildings) {
            list.add(new int[]{b[0], -b[2]});
            list.add(new int[]{b[1], b[2]});
        }
        
        Collections.sort(list, new Comparator<int[]>(){
            public int compare(int[] l1, int[] l2) {
                if(l1[0] != l2[0]) {
                   return l1[0] - l2[0]; 
                } else {
                   return l1[1] - l2[0];
                }
            }
        });
        
        Queue<Integer> q = new PriorityQueue(new Comparator<Integer>(){
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        });
        
        q.offer(0);
        // prev用于记录上次keypoint的高度
        int prev = 0;
        for(int[] h:list) {
            // 将左顶点加入堆中
            if(h[1] < 0) {
                q.offer(-h[1]);
            } else {
            // 将右顶点对应的左顶点移去
                q.remove(h[1]);
            }
            int cur = q.peek();
            // 如果堆的新顶部和上个keypoint高度不一样，则加入一个新的keypoint
            if(prev != cur) {
                result.add(new int[]{h[0], cur});
                prev = cur;
            }
        }
        return result;
    }
}