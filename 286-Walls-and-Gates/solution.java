// public class Solution {
//     public void wallsAndGates(int[][] rooms) {
//         if(rooms.length < 1) return;
//         for(int i = 0; i < rooms.length; i++) {
//             for(int j = 0; j < rooms[0].length; j++) {
//                 //从gate出发进行搜索
//                 if(rooms[i][j] == 0) {
//                     dfs(rooms, i, j, 0);
//                 }
//             }
//         }
//     }
    
//     public void dfs(int[][] rooms, int i, int j, int dis) {
//         if(i < 0 || j < 0 || i >= rooms.length || j >= rooms[0].length) return;
        
//         if(rooms[i][j] < dis) {
//             return;
//         } else {
//             rooms[i][j] = dis;
//             dfs(rooms, i - 1, j, dis + 1);
//             dfs(rooms, i + 1, j, dis + 1);
//             dfs(rooms, i, j - 1, dis + 1);
//             dfs(rooms, i, j + 1, dis + 1);
//         }
//     }
// }

//bfs
public class Solution {
    public void wallsAndGates(int[][] rooms) {
        if(rooms.length < 1) return;
        Queue<int[]> q = new LinkedList();
        
        for(int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms[0].length; j++) {
                if(rooms[i][j] == 0) {
                    q.offer(new int[]{i,j});
                }
            }
        }
        
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int row = temp[0];
            int col = temp[1];
            
            if(row > 0 && rooms[row-1][col] == Integer.MAX_VALUE) {
                rooms[row-1][col] = rooms[row][col] + 1;
                q.offer(new int[]{row - 1, col});
            }
            
            if(row < rooms.length - 1 && rooms[row + 1][col] == Integer.MAX_VALUE) {
                rooms[row+1][col] = rooms[row][col] + 1;
                q.offer(new int[]{row + 1, col});
            }
            
            if(col > 0 && rooms[row][col - 1] == Integer.MAX_VALUE) {
                rooms[row][col - 1] = rooms[row][col] + 1;
                q.offer(new int[]{row, col - 1});
            }
            
            if(col < rooms[0].length - 1 && rooms[row][col + 1] == Integer.MAX_VALUE) {
                rooms[row][col + 1] = rooms[row][col] + 1;
                q.offer(new int[]{row, col + 1});
            }
        }
    }
}