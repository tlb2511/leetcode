package 图.最小路径和;

public class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int[] arr = new int[col];
        arr[0] = grid[0][0];
        for(int j = 1; j < col; j ++){
            arr[j] = grid[0][j] + arr[j-1];
        }
        for(int i = 1; i < row; i ++){
            for(int j = 0; j < col; j++){
                if(j == 0){
                    arr[j] += grid[i][j];
                }else{
                    arr[j] = grid[i][j] + Math.min(arr[j-1],arr[j]);
                }
            }
        }
        return arr[col-1];
    }
}
