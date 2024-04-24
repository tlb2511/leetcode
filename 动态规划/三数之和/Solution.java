package 动态规划.三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for(int k = 0; k < len; k ++){
            if(k > 0 && nums[k] == nums[k-1])continue;
            int target = -nums[k];
            int l = 0, r = len - 1;
            while(l < r){
                int v = nums[l] + nums[r];
                if(v < target){
                    l++;
                }else if(v > target){
                    r--;
                }else{
                    List<Integer> temp = new ArrayList<>();
                    temp.add(k);
                    temp.add(l);
                    temp.add(r);
                    ans.add(temp);
                    while(l < r && nums[l+1] == nums[l]){
                        l++;
                    }
                    while(l < r && nums[r-1] == nums[r]){
                        r--;
                    }
                    l++;
                    r--;
                }
            }
        }
        return ans;
    }
}
