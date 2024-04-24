package 图.矩阵中移动的最大次数;

import java.util.Arrays;

public class Solution {

    static int[][] matrix = {{-1,1},{0,1},{1,1}};
    public static int maxMoves(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int res = 0;
        int[][] arr = new int[row][col];
        for(int i = 0; i < row; i++){
            res = Math.max(res, func(grid,arr,i,0,row,col));
        }
        return res;
    }
    static int func(int[][] grid, int[][] map, int i, int j, int row, int col){
        //if(i < 0 || i >= row || j < 0 || j >= col)return 0;
        int s = 0;
        for(int m = 0; m < 3; m ++){
            int newx = i + matrix[m][0];
            int newy = j + matrix[m][1];
            if(newx < 0 || newx >= row || newy < 0 || newy >= col)continue;
            if(grid[newx][newy] <= grid[i][j])continue;
            if(map[newx][newy] != 0){
                s = Math.max(s, map[newx][newy] + 1);
            }else{
                s = Math.max(s, func(grid,map,newx,newy,row,col) + 1);
            }
        }
        map[i][j] = s;
        return s;
    }

    public static void main(String[] args) {
        //int[][] arr = {{2,4,3,5},{5,4,9,3},{3,4,2,11},{10,9,13,15}};
        //int[][] arr = {{1,2},{3,4}};
        int[][] arr = {{3,2,4},{2,1,9},{1,1,7}};
        int i = maxMoves(arr);
        System.out.println(i);
    }
}
