package 位运算.最大二进制奇数;

public class Solution {
    public String maximumOddBinaryNumber(String s) {
        int n = s.length(), count = 0;
        String ans = "";
        for(char c : s.toCharArray()){
            if(c == '1')count++;
        }
        for(int i = 0; i < count - 1; i++)ans += '1';
        for(int i = 0; i < n - count; i ++)ans += '0';
        ans += '1';
        return ans;
    }
}
