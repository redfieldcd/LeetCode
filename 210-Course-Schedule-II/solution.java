//DFS
public class Solution {
    int n = 0;
    class Course{
        List<Course> pre;
        int id;
        boolean visited = false;
        boolean tested = false;
        
        public Course(int i) {
            this.id = i;
            this.pre = new LinkedList();
        }
        
        public void add(Course i) {
            pre.add(i);
        }
        
    }
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Course[] courses = new Course[numCourses];
        int[] res = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            courses[i] = new Course(i);
        }
        
        for(int i = 0; i < prerequisites.length; i++) {
            courses[prerequisites[i][0]].add(courses[prerequisites[i][1]]);
        }
        
        
        for(int i = 0; i < numCourses; i++) {
            if(isCycle(courses[i], res)) {
                return new int[0];
            }
        }
        
        return res;
    }
    
    public boolean isCycle(Course course, int[] res) {
        if(course.tested) return false;
        if(course.visited) return true;
        
        course.visited = true;
        for(Course c: course.pre) {
            if(isCycle(c, res)) {
                return true;
            }
        }
        course.tested = true;
        res[n++] = course.id;
        return false;
    }
    
    
}

// BFS use indegree
// public class Solution {
//     public int[] findOrder(int numCourses, int[][] prerequisites) {
//         Queue<Integer> q = new LinkedList();
//         int[] inDegree = new int[numCourses];
//         Set<Integer> set = new HashSet();
    
//         int[] res = new int[numCourses];
        
//         for(int[] arr : prerequisites) {
//             int first = arr[1];
//             int second = arr[0];
//             inDegree[second]++;
//         }
        
//         for(int i = 0; i < inDegree.length; i++) {
//             if(inDegree[i] == 0) {
//                 q.offer(i);
//             }
//         }
        
//         int j = 0;
//         while(!q.isEmpty()) {
//             int cur = q.poll();
//             res[j] = cur;
//             j++;
//             for(int[] l : prerequisites) {
//                 if(l[1] == cur) {
//                     inDegree[l[0]]--;
//                     if(inDegree[l[0]] == 0) {
//                         q.offer(l[0]);
//                     }
//                 }
//             }
//         }
        
//         return j == numCourses ? res : new int[0];
        
        
//     }
// }