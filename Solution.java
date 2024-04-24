import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        System.out.println(map.put(0,map.get(0)+1));
    }
}