package 数组.跳跃游戏II;

public class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n <= 1)return 0;
        int begin = 0, end = 1, maxl = nums[0], ans = 0;
        while(end <= n - 1){
            for(int i = begin; i < end; i++){
                maxl = Math.max(maxl, i + nums[i]);
            }
            begin = end;
            end = maxl + 1;
            ans++;
        }
        return ans;
    }
}
