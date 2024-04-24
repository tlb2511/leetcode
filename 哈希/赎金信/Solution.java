package 哈希.赎金信;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < magazine.length(); i++){
            char v = magazine.charAt(i);
            if(!map.containsKey(v)){
                map.put(v,1);
            }else{
                int n = map.get(v);
                map.replace(v,++n);
            }
        }
        for(int i = 0; i < ransomNote.length(); i ++){
            char val = ransomNote.charAt(i);
            if(!map.containsKey(val)){
                return false;
            }else{
                if(map.get(val) <= 0){
                    return false;
                }else{
                    int n = map.get(val);
                    map.replace(val,--n);
                }
            }
        }
        return true;
    }
}
