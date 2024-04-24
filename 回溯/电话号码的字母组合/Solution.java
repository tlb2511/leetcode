package 回溯.电话号码的字母组合;

import java.util.*;

public class Solution {
    static List<String> ans = new ArrayList<>();
    static String[] map = {
            "-",
            "-",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };
    public static List<String> letterCombinations(String digits) {
        int n = digits.length();
        if(n == 0)return ans;
        StringBuilder path = new StringBuilder();
        fun(digits,n,0,path,map);
        return ans;

    }
    static void fun(String s, int n, int curIndex, StringBuilder path, String[] map){
        if(curIndex == n){
            ans.add(path.toString());
            return;
        }
        String temp = map[s.charAt(curIndex)-'0'];
        for (Character c : temp.toCharArray()) {
            path.append(c);
            fun(s,n,curIndex+1,path,map);
            path.deleteCharAt(path.length()-1);
        }
    }

    public static void main(String[] args) {
        String s = "7";
        List<String> strings = letterCombinations(s);
        System.out.println(strings);
    }
}
