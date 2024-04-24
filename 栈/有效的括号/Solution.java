package 栈.有效的括号;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        char[] l = {'(','[','{'};
        char[] r = {')',']','}'};
        for(char c : s.toCharArray()){
            if(map.containsKey(c)){
                stack.addLast(c);
            }else{
                if(stack.isEmpty())return false;
                char top = stack.getLast();
                if(map.containsKey(top) && map.get(top) == c) {
                    stack.removeLast();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
