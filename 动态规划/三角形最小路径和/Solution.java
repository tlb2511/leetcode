package 动态规划.三角形最小路径和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int col = triangle.get(row - 1).size();
        int[] dp = new int[col];
        dp[0] = triangle.get(0).get(0);
        if(row == 1)return dp[0];
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i < row; i ++){
            for(int j = i; j >= 0; j --){
                if(j == i){
                    dp[j] = dp[j - 1] + triangle.get(i).get(j);
                }else if(j == 0){
                    dp[j] = dp[j] + triangle.get(i).get(j);
                }else{
                    dp[j] = Math.min(dp[j], dp[j-1]) + triangle.get(i).get(j);
                }
                if(i == row -1){
                    ans = Math.min(ans,dp[j]);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] t =  {{2},{3,4},{6,5,7},{4,1,8,3}};

        List<List<Integer>> l = new ArrayList<>();

        List<Integer> l1 = Arrays.asList(2);
        List<Integer> l2 = Arrays.asList(3,4);
        List<Integer> l3 = Arrays.asList(6,5,7);
        List<Integer> l4 = Arrays.asList(4,1,8,3);

        l.add(l1);
        l.add(l2);
        l.add(l3);
        l.add(l4);

        int i = minimumTotal(l);

    }
}
