package 哈希.同构字符串;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map = new HashMap<>();//s 映射到 t
        Map<Character,Character> temp = new HashMap<>();//t 被谁映射
        if(s.length() != t.length())return false;
        int len = s.length();
        for(int i = 0; i < len; i ++){
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if(map.containsKey(cs)){
                if(map.get(cs) != ct)return false;
            }else{
                map.put(cs,ct);
                if(temp.containsKey(ct))return false;
                temp.put(ct,cs);
            }
        }
        return true;
    }
}
