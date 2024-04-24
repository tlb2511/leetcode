package 字符串.无重复字符的最长子串;

import java.util.*;

public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0, ans = 0;
        Set<Character> set = new HashSet<>();
        Map<Character,Integer> map = new HashMap<>();
        //Deque<String> s = new ArrayDeque<>();
        PriorityQueue<Integer> s1 = new PriorityQueue<>();
        for(int i = 0; i < n; i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left, map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            ans = Math.max(ans, i - left + 1);

        }
        return ans;
    }

    public static void main(String[] args) {
        int i = lengthOfLongestSubstring("abca");
    }
}
