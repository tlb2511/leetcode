package 图.地图分析;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int maxDistance(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        Deque<int[]> queue = new ArrayDeque<>();
        int moves[][] = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j ++){
                if(grid[i][j] == 1){
                    queue.addLast(new int[]{i,j});
                }
            }
        }
        if(queue.size() == n*n)return -1;
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i = 0; i < len; i ++){
                int temp[] = queue.removeFirst();
                int curRow = temp[0];
                int curCol = temp[1];
                for(int j = 0; j < 4; j ++){
                    if(bfs(grid,curRow+moves[j][0],curCol+moves[j][1],n)){
                        queue.addLast(new int[]{curRow+moves[j][0],curCol+moves[j][1]});
                    }
                }
            }
            ans++;
        }
        return ans - 1;
    }
    boolean bfs(int[][] grid, int i, int j, int n){
        if(i < 0 || i >= n || j < 0 || j >= n || grid[i][j] != 0)return false;
        grid[i][j] = 2;
        return true;
    }
}
