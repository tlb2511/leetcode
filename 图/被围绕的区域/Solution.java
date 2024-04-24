package 图.被围绕的区域;

public class Solution {
    int[][] m = {{1,0},{-1,0},{0,1},{0,-1}};
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        for(int i = 0; i < row; i ++){
            func(board,i,0,row,col);
            func(board,i,col-1,row,col);
        }

        for(int j = 0; j < col; j ++){
            func(board,0,j,row,col);
            func(board,row-1,j,row,col);
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    void func(char[][] g, int i, int j, int row, int col){
        if(i < 0 || i >= row || j < 0 || j >= col || g[i][j] != 'O')return;
        g[i][j] = '#';

        for(int k = 0; k < 4; k ++){
            int newX = i + m[k][0];
            int newY = j + m[k][1];
            func(g,newX,newY,row,col);
        }
    }
}
