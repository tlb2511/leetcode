package 图.最大人工岛;

import java.util.*;

public class Solution {
    public int largestIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int ans = 0;
        Map<Integer,Integer> map = new HashMap<>();//用来保存每个岛屿的编号：面积
        map.put(0,0);
        int index = 2;
        for(int i = 0; i < row; i ++){
            for(int j = 0; j < col; j ++){
                if(grid[i][j] == 1){
                    map.put(index,dfs(grid,i,j,row,col,index));
                    index++;
                }
            }
        }
        boolean flag = false;//判断该岛屿有没有海洋，如果没有海洋那么仅有一个岛屿，最终结果就是这个岛屿的面积
        for(int i = 0; i < row; i ++){
            for(int j = 0; j < col; j ++){
                if(grid[i][j] == 0){
                    flag = true;
                    int area = 1;//记录当前海洋填上之后，产生的面积
                    //上下左右四个方向
                    int xia = dfsGetAns(grid,i+1,j,row,col);
                    int shang = dfsGetAns(grid,i-1,j,row,col);
                    int you = dfsGetAns(grid,i,j+1,row,col);
                    int zuo = dfsGetAns(grid,i,j-1,row,col);

                    //四个方向中去除掉为0的方向，因为为0代表该方向没有岛屿
                    //使用set记录四个方向中出现的岛屿，即使重复也没关系，因为重复岛屿只能算成一个面积
                    Set<Integer> mapId = new HashSet<>();
                    if(shang != 0){
                        mapId.add(shang);
                    }
                    if(xia != 0){
                        mapId.add(xia);
                    }
                    if(zuo != 0){
                        mapId.add(zuo);
                    }
                    if(you != 0){
                        mapId.add(you);
                    }
                    if(!mapId.isEmpty()){
                        for(int entry : mapId){
                            area += map.get(entry);
                        }
                    }

                    ans = Math.max(ans, area);
                }
            }
        }
        if(flag == false){
            return map.get(grid[0][0]);
        }
        return ans;
    }
    //计算当前岛屿面积，并将该岛屿序号设置为val
    int dfs(int[][] grid, int x, int y, int row, int col, int val){
        if(x < 0 || x >= row || y < 0 || y >= col || grid[x][y] != 1)return 0;
        grid[x][y] = val;
        return 1 + dfs(grid, x + 1, y, row, col, val) +
        dfs(grid, x - 1, y, row, col, val) +
        dfs(grid, x, y + 1, row, col, val) +
        dfs(grid, x , y - 1, row, col, val);
    }
    int dfsGetAns(int[][] grid, int x, int y, int row, int col){
        if( x < 0 || x >= row || y < 0 || y >= col)return 0;
        return grid[x][y];
    }
}
