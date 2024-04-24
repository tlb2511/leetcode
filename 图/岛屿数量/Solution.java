package 图.岛屿数量;

public class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int ans = 0;
        for(int i = 0; i < row; i ++){
            for(int j = 0; j < col; j ++){
                if(grid[i][j] == '1'){
                    ans++;
                    dfs(grid,i,j,row,col);
                }
            }
        }
        return ans;
    }
    void dfs(char[][] grid, int x, int y, int row, int col){
        if(x < 0 || x >= row || y < 0 || y >= col || grid[x][y] != '1')return;
        grid[x][y] = '2';
        dfs(grid, x + 1, y, row, col);
        dfs(grid, x - 1, y, row, col);
        dfs(grid, x, y + 1, row, col);
        dfs(grid, x, y - 1, row, col);
    }
}
