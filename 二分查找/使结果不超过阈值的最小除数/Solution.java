package 二分查找.使结果不超过阈值的最小除数;

public class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int mn = Integer.MAX_VALUE;
        for(int i : nums){
            mn = Math.max(mn,i);
        }
        int l = 1, r = mn;
        while(l < r){
            int m = (l + r) >>> 1;
            if(func(nums,m,threshold) == -1){
                r = m;
            }else{
                l = m + 1;
            }
        }
        return r;
    }
    public int func(int[] nums, int cs, int key){
        int ans = 0;
        for(int i :nums){
            if(i % cs == 0){
                ans += i/cs;
            }else{
                ans += i/cs + 1;
            }
        }
        return ans > key ? 1 : -1;
    }
}
