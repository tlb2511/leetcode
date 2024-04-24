package 字符串.最长公共前缀;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length, m = strs[0].length(), index = 0;
        String ans = "";
        while(index < m){
            if(index < strs[0].length()){
                char v = strs[0].charAt(index);
                for(int i = 1; i < n; i ++){
                    if(index >= strs[i].length() || strs[i].charAt(index) != v)return ans;
                }
                ans += String.valueOf(v);
                index++;
            }else{
                return ans;
            }

        }
        return ans;
    }
}
