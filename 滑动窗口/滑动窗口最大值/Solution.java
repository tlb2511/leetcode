package 滑动窗口.滑动窗口最大值;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 1)return nums;
        Deque<Integer> queue = new ArrayDeque<>();
        int size = nums.length - k + 1;
        int[] res = new int[size];
        int index = 0;
        int l = 0, r = k;
        for(int i = 0; i < k; i ++){
            int v = nums[i];
            if(queue.isEmpty()){
                queue.addLast(v);
            }else{
                while(!queue.isEmpty() && queue.getLast() < v){
                    queue.removeLast();
                }
                queue.addLast(v);
            }
        }
        res[index++] = queue.getFirst();

        while(r < nums.length){
            if(nums[l] == queue.getFirst()){
                queue.removeFirst();

            }
            while(!queue.isEmpty() && queue.getLast() < nums[r]){
                queue.removeLast();
            }
            queue.addLast(nums[r]);
            res[index] = queue.getFirst();
            index++;
            r++;
            l++;
        }
        return res;
    }
}
