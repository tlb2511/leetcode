package 字符串.将标题首字母大写;

public class Solution {
    public static String capitalizeTitle(String title) {
        int n = title.length();
        int l = 0, r = 0;
        StringBuilder str = new StringBuilder(title);
        while(r < n){
            while(r < n && str.charAt(r) != ' ' ){
                if(str.charAt(r) < 97){
                    str.setCharAt(r,(char)(str.charAt(r)+32));
                }
                r++;
            }

            if(r - l > 2){
                str.setCharAt(l,(char)(str.charAt(l)-32));
            }
            r++;
            l = r;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String s = "ac ABbcc dDfgd a";
        String s1 = capitalizeTitle(s);
        System.out.println(s1);
    }
}
