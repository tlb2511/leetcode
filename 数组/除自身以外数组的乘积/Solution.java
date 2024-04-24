package 数组.除自身以外数组的乘积;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] r = new int[n];
        r[n-1] = nums[n-1];
        for(int i = n-1; i >= 0; i --){
            r[i] = r[i+1] * nums[i];
        }
        int tmp = 1;
        for(int i = 0; i < n; i ++){
            if(i == n-1){
                ans[i] = tmp;
            }else{
                ans[i] = tmp * r[i+1];
            }
            tmp *= nums[i];
        }
        return ans;
    }
}
