package 数组.有效的数独;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        //int[][] m = new int[3][3];
        Set<Character>[] mrow = new HashSet[9];
        Set<Character>[] mcol = new HashSet[9];
        Set<Character>[] set = new HashSet[9];
        Arrays.setAll(mrow, e -> new HashSet<>());
        Arrays.setAll(mcol, e -> new HashSet<>());
        Arrays.setAll(set, e -> new HashSet<>());
        //if(set[0].contains('.'))return false;
        for(int i = 0; i < 9; i ++){
            for(int j = 0; j < 9; j ++){
                char index = board[i][j];
                if(index == '.')continue;
                int temp_row = i/3;
                int temp_col = j/3;
                int pos = temp_row*3 + temp_col;
                if(set[pos].contains(index))return false;
                if(mrow[i].contains(index))return false;
                if(mcol[j].contains(index))return false;
                set[pos].add(index);
                mrow[i].add(index);
                mcol[j].add(index);
            }
        }
        return true;
    }
}
