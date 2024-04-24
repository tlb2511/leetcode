package 双指针.接雨水;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);
        int i = 1;
        while(i < n){
            int top = height[stack.getLast()];
            if(height[i] < top){
                int topi = stack.removeLast();
                if(stack.isEmpty()){
                    stack.addLast(i);
                }else{
                    int len = i - topi;
                    int curtop = height[stack.getLast()];
                    int hei = Math.min(curtop,height[i]) - top;
                    ans += len * hei;
                    continue;
                }
            }else if(height[i] > top){
                stack.addLast(i);
            }
            i++;
        }
        return ans;
    }
}
