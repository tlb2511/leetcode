package 字符串.找出字符串中第一个匹配项的下标;

public class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        if(m < n)return -1;
        int i = 0, j = 0;
        while(i < m){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
                if(j == n)return i - j;
            }else{
                i = i - j + 1;
                j = 0;
            }
        }
        return -1;
    }
}
