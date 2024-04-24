package 字符串.判断子序列;

public class Solution {
    public static boolean isSubsequence(String s, String t) {
        int lastnum = -1;
        int j = 0;
        for(int i = 0; i < s.length(); i ++){
            for(j = lastnum + 1; j < t.length(); j ++){
                if(s.charAt(i) == t.charAt(j)){
                    lastnum = j;
                    break;
                }
            }
            if(j == t.length()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean subsequence = isSubsequence("axc", "ahbgdc");
    }
}
