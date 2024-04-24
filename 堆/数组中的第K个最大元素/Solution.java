package 堆.数组中的第K个最大元素;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap_max = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int num : nums) {
            if(heap_max.size() < k){
                heap_max.add(num);
            }else{
                int temp = heap_max.peek();
                if(temp < num){
                    heap_max.poll();
                    heap_max.add(num);
                }
            }
        }
        return heap_max.peek();
    }
}
