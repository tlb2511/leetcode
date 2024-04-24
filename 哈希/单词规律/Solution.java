package 哈希.单词规律;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static boolean wordPattern(String pattern, String s) {
        String[] split = s.split(" ");
        if(pattern.length() != split.length)return false;
        int len = pattern.length();
        Map<Character,String> map = new HashMap<>();
        Map<String,Character> temp = new HashMap<>();
        for(int i = 0; i < len; i ++){
            char cp = pattern.charAt(i);
            String str = split[i];
            if(map.containsKey(cp)){
                if(!map.get(cp).equals(str))return false;
            }else{
                if(temp.containsKey(str))return false;
                temp.put(str,cp);
                map.put(cp,str);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "abba";
        String s = "dog cat cat dog";
        boolean b = wordPattern(str, s);
    }
}
