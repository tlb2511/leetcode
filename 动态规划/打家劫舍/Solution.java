package 动态规划.打家劫舍;

public class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1)return nums[0];
//        int[] dp = new int[n];
//        dp[0] = nums[0];
//        dp[1] = Math.max(nums[0],nums[1]);
        int prve = nums[0], pre = Math.max(nums[0],nums[1]), ans = 0;
        for(int i = 2; i < n; i ++){
            ans = Math.max(pre, prve + nums[i]);
        }
        return ans;
    }
}
