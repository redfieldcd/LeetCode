public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Queue<Integer> q = new LinkedList();
        int[] inDegree = new int[numCourses];
        Set<Integer> set = new HashSet();
    
        int[] res = new int[numCourses];
        
        for(int[] arr : prerequisites) {
            int first = arr[1];
            int second = arr[0];
            inDegree[second]++;
        }
        
        for(int i = 0; i < inDegree.length; i++) {
            if(inDegree[i] == 0) {
                q.offer(i);
            }
        }
        
        int j = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            res[j] = cur;
            j++;
            for(int[] l : prerequisites) {
                if(l[1] == cur) {
                    inDegree[l[0]]--;
                    if(inDegree[l[0]] == 0) {
                        q.offer(l[0]);
                    }
                }
            }
        }
        
        return j == numCourses ? res : new int[0];
        
        
    }
}