package 动态规划.打家劫舍II;

public class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1)return nums[0];
        if(n == 2)return Math.max(nums[0],nums[1]);
        int ans1 = func(nums,0,n-2);
        int ans2 = func(nums,1,n-1);
        return Math.max(ans1,ans2);
    }
    public int func(int[] arr, int l, int r){
        int n = arr.length, prev = 0, pre = 0, ans = 0;
        for(int i = l; i <= r; i ++){
            ans = Math.max(prev + arr[i], pre);
            prev = pre;
            pre = ans;
        }
        return ans;
    }
}
