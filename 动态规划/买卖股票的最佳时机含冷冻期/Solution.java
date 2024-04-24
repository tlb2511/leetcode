package 动态规划.买卖股票的最佳时机含冷冻期;

public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        //如果就一天数据，不能买卖，返回0
        if(n == 1)return 0;
        //dp[i][0]表示第0天没有持有股票
        //dp[i][1]表示第0天没有持有股票
        //假设第一天有0元
        dp[0][0] = 0;//没持有股票，说明当前手里没钱
        dp[0][1] = -prices[0];//持有股票，需要借钱买股票，所以金额是负数
        //第二天要考虑前一天的情况
        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);//今天没股票，可能是昨天也没有买股票，或者是昨天买了今天卖了
        dp[1][1] = Math.max(dp[0][1], dp[0][0] - prices[1]);//今天有股票，可能是昨天就买了股票，或者是昨天没买今天买了。此时是个特殊情况，没考虑前天的事情
        for(int i = 2; i < n; i ++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0] - prices[i]);
        }
        return dp[n-1][0];
    }
}
