package 动态规划.买卖股票的最佳时机II;

public class Solution {
//    public int maxProfit(int[] prices) {
//        int ans = 0;
//        int mn = prices[0];
//        for(int i = 1; i < prices.length; i ++){
//            if(prices[i] > mn){
//                ans += prices[i] - mn;
//                mn = prices[i];
//            }else{
//                mn = prices[i];
//            }
//        }
//        return ans;
//    }
    public int maxProfit(int[] prices){
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1; i < n; i ++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[n-1][0];
    }
}
