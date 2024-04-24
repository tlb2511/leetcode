package 回溯.组合总和Ⅳ;

import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static int res = 0;
    public static int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        func(nums,0,target);
        return res;
    }

    static boolean func(int[] nums, int cur, int target){
        if(cur > target)return false;
        if(cur == target)res++;
        int count = cur;
        for(int i = 0; i < nums.length; i ++){
            count += nums[i];
            if(!func(nums, count, target))break;
            count -= nums[i];
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {3};
        int i = combinationSum4(nums, 3);
        System.out.println(i);
    }
}
