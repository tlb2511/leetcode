package 数组.螺旋矩阵;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> ans = new ArrayList<>();
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        func(matrix,row,col,0,0);
        return ans;
    }
    public void func(int[][] matrix, int row, int col, int i, int j){
        if(i >= row || j >= col)return;
        for(int n = j; n < col; n ++){
            ans.add(matrix[i][n]);
        }
        for(int m = i+1; m < row; m ++){
            ans.add(matrix[m][col-1]);
        }
        if(i != row -1){
            for(int n = col - 2; n >= j; n --){
                ans.add(matrix[row - 1][n]);
            }
        }
        if(j != col - 1){
            for(int m = row - 2; m >= i+1; m --){
                ans.add(matrix[m][j]);
            }
        }

        func(matrix,row-1,col-1,i+1,j+1);
    }

}
