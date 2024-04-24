package 字符串.反转字符串中的单词;

public class Solution {
    public static String reverseWords(String s) {
        String ans = "";
        int n = s.length();
        int l = 0, r = n - 1;
        //去掉左右两边空格
        while(s.charAt(l) == ' ')l++;
        while(s.charAt(r) == ' ')r--;

        s = s.substring(l,r+1);

        l = s.length() - 1;
        r = s.length() - 1;
        while (l >= 0){
            while(l >= 0 && s.charAt(l) != ' '){
                l--;
            }
            ans += s.substring(l+1,r+1);
            ans += ' ';
            while(l >= 0 && s.charAt(l) == ' '){
                l--;
            }
            r = l;
        }
        //ans += s.substring(0,r+1);
        ans = ans.substring(0,ans.length()-2);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("  abc dd  "));
    }
}
