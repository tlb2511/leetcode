package 字符串.最后一个单词的长度;

public class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int ans = 0;
        int i = n - 1;
        while(i >= 0 && s.charAt(i) == ' ')i--;
        while(i >= 0){
            if(s.charAt(i) != ' '){
                i--;
                ans++;
            }
        }
        return ans;
    }
}
