package 栈.简化路径;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public String simplifyPath(String path) {
        String[] str = path.split("/");
        String ans = "";
        Deque<String> deque = new ArrayDeque<>();
        for (String s : str) {
            if(s.equals("..")){
                deque.removeLast();
            }else{
                if(s.length() > 0 && !s.equals('.')){
                    deque.addLast(s);
                }
            }
        }
        if(deque.isEmpty())return "/";
        while(!deque.isEmpty()){
            String temp = deque.removeFirst();
            ans = ans + "/" + temp;
        }
        return ans;
    }
}
