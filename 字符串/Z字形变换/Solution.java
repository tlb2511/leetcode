package 字符串.Z字形变换;

import java.util.*;

public class Solution {
    public static String convert(String s, int numRows) {
        if(numRows == 1)return s;

        List<StringBuilder> arr = new ArrayList<>();
        for(int i = 0; i < numRows; i++)arr.add(new StringBuilder());
        boolean flag = true;
        int row  = 0;
        StringBuilder ans = new StringBuilder();
        for(char c : s.toCharArray()){
            arr.get(row).append(c);
            if(row == numRows - 1){
                flag = false;
            }else if(row == 0){
                flag = true;
            }
            row = flag == true ? row + 1 : row - 1;
        }
        for (StringBuilder str : arr) {
            ans.append(str);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String paypalishiring = convert("PAYPALISHIRING", 3);
    }
}
