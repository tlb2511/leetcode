//package 双指针.好子数组的最大分数;
//
//public class Solution {
//    public int maximumScore(int[] nums, int k) {
//        int l = 0, r = k, n = nums.length;
//        int ans = 0;
//        while(l < k && r < n){
//            ans = Math.max(ans, Math.min(nums[l],nums[r]) * (r - l + 1));
//            if(l + 1 <= k && r + 1 < n){
//                if(nums[l+1] >= nums[r+1]){
//                    l = l + 1;
//                }else{
//                    r = r + 1;
//                }
//            }
//        }
//        if(l > k && n) {
//
//        }else if(r >= n){
//
//        }
//
//    }
//}
