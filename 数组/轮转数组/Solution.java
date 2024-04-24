package 数组.轮转数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        int v = k%n;
        reverse(nums,0,n-1);
        reverse(nums,0,v);
        reverse(nums,v+1,n-1);
    }
    static void reverse(int[] nums, int l, int r){
        for(int i = l; i <= (l+r)>>>1; i ++){
            int temp = nums[i];
            nums[i] = nums[r-(i-l)];
            nums[r-(i-l)] = temp;
        }
    }
}
