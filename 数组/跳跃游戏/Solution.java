package 数组.跳跃游戏;

public class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n <= 1)return true;
        int maxl = nums[0];
        for(int i = 0; i < n; i ++){
            if(i <= maxl){
                maxl = Math.max(maxl, i + nums[i]);
                if(maxl >= n - 1)return true;
            }else{
                return false;
            }
        }
        return false;
    }
}
