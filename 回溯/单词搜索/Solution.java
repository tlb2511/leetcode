package 回溯.单词搜索;

public class Solution {
    static int[][] matrix = {{1,0},{-1,0},{0,1},{0,-1}};
    static public boolean exist(char[][] board, String word) {
        int row = board.length, col = board[0].length;
        char[][] visit = new char[row][col];
        for(int i = 0; i < row; i ++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == word.charAt(0)){
                    visit[i][j] = 1;
                    if(func(board,word,visit,i,j,row,col,0))return true;
                    visit[i][j] = 0;
                }
            }
        }
        return false;
    }
    static boolean func(char[][] board, String word, char[][] visit, int i, int j, int row, int col, int cur){
        //if(cur == word.length())return true;
        if(board[i][j] != word.charAt(cur)){
            return false;
        }
        if(cur == word.length()-1)return true;

        for(int k = 0; k < 4; k ++){
            int newi = i+matrix[k][0];
            int newj = j+matrix[k][1];
            if(newi < 0 || newi >= row || newj < 0 || newj >= col)continue;
            if(visit[newi][newj] == 1)continue;
            visit[newi][newj] = 1;
            if(func(board,word,visit,newi,newj,row,col,cur+1))return true;
            visit[newi][newj] = 0;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] arr = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCB";
        boolean exist = exist(arr, word);
        System.out.println(exist);
    }
}
