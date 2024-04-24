package 动态规划.爬楼梯;

public class Solution {
    public int climbStairs(int n) {
//        int[] dp = new int[n+1];
//        dp[0] = 1;
//        dp[1] = 1;
        int i_2 = 1, i_1 = 1, ans = 0;
        for(int i = 2; i <= n; i ++){
            ans = i_2 + i_1;
            i_2 = i_1;
            i_1 = ans;
        }
        return ans;
    }
}
