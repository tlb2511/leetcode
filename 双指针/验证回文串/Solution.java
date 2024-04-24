package 双指针.验证回文串;

public class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while(l < r){
            while(l <= s.length() -1 && (isChar(s.charAt(l)) == false && isDigit(s.charAt(l)) == false)){
                l++;
                if(l == s.length())return true;
            }
            while(r >= 0 && (isChar(s.charAt(r)) == false && isDigit(s.charAt(r)) == false)){
                r--;
                if(r == -1)return true;
            }
            //两边都是数字
            if(isDigit(s.charAt(l)) && isDigit(s.charAt(r))){
                if(s.charAt(l) != s.charAt(r)){
                    return false;
                }
            }
            //两边都是字母
            if(isChar(s.charAt(l)) && isChar(s.charAt(r))){
                if(s.charAt(l) != s.charAt(r) && Math.abs(s.charAt(l) - s.charAt(r)) != 32){
                    return false;
                }
            }
            //左边字符，右边数字
            if(isChar(s.charAt(l)) && isDigit(s.charAt(r))){
                return  false;
            }
            //左边数字，右边字符
            if(isDigit(s.charAt(l)) && isChar(s.charAt(r))){
                return  false;
            }
            l++;
            r--;
        }
        return true;
    }
    private boolean isChar(char c){
        if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))return true;
        return false;
    }
    private boolean isDigit(char c){
        if(c >= '0' && c <= '9')return true;
        return false;
    }
}
