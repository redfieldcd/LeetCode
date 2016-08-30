public class Solution {
    public void wallsAndGates(int[][] rooms) {
        if(rooms.length < 1) return;
        for(int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms[0].length; j++) {
                //从gate出发进行搜索
                if(rooms[i][j] == 0) {
                    dfs(rooms, i, j, 0);
                }
            }
        }
    }
    
    public void dfs(int[][] rooms, int i, int j, int dis) {
        if(i < 0 || j < 0 || i >= rooms.length || j >= rooms[0].length) return;
        
        if(rooms[i][j] < dis) {
            return;
        } else {
            rooms[i][j] = dis;
            dfs(rooms, i - 1, j, dis + 1);
            dfs(rooms, i + 1, j, dis + 1);
            dfs(rooms, i, j - 1, dis + 1);
            dfs(rooms, i, j + 1, dis + 1);
        }
    }
}