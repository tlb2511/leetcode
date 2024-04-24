package 哈希.最大字符串配对数目;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        Set<String> set = new HashSet<>();
        int res = 0;
        for(String str : words){
            String strbuf = new StringBuffer(str).reverse().toString();
            if(set.contains(strbuf)){
                res++;
            }else{
                set.add(str);
            }
        }
        return res;
    }
}
