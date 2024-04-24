package 回溯.括号生成;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    static public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        func(2*n,0,0,path,ans);
        return ans;
    }
    static void func(int n, int len, int count,StringBuilder path, List<String> ans){
        if(count > n/2)return;
        if(len == n){
            ans.add(path.toString());
            return;
        }

        if(count <= len/2){
            path.append('(');
            func(n,len+1,count+1,path,ans);
        }else{
            path.append('(');
            func(n,len+1,count+1,path,ans);
            path.deleteCharAt(path.length()-1);

            path.append(')');
            func(n,len+1,count,path,ans);
            path.deleteCharAt(path.length()-1);
        }
    }

    public static void main(String[] args) {
        List<String> strings = generateParenthesis(3);
        System.out.println(strings);
    }
}
