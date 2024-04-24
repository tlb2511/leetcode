package 滑动窗口.长度最小的子数组;

public class Solution {
    //方法1  暴力搜索
//    public int minSubArrayLen(int target, int[] nums) {
//        int ans = Integer.MAX_VALUE;
//        for(int i = 0; i < nums.length; i ++){
//            int count = 0;
//            for(int j = i; j < nums.length; j ++){
//                count += nums[j];
//                if(count >= target){
//                    ans = Math.min(ans, j - i + 1);
//                    break;
//                }
//                if(i == 0 && j == nums.length - 1){
//                    return 0;
//                }
//            }
//        }
//        return ans;
//    }


    //方法2   前缀和 + 二分查找 时间复杂度n*log(n)
//    public static int minSubArrayLen(int target, int[] nums){
//        int len = nums.length;
//        int ans = Integer.MAX_VALUE;
//        int sums[] = new int[len+1];
//        sums[0] = 0;
//        for(int i = 1; i <= len; i ++){
//            sums[i] = sums[i-1] + nums[i-1];
//        }
//        for(int i = 0; i <= len; i ++){
//            int val = sums[i] + target;
//            int bound = binarySearch(val,sums);
//            if(bound == -1){
//                if(i == 0)return 0;
//                break;
//            }
//            ans = Math.min(ans,bound - i);
//        }
//        return ans;
//    }
//    static int binarySearch(int target, int[] nums){
//        int len = nums.length;
//        int l = 0, r = len - 1;
//        while(l < r){
//            int m = (l + r)/2;
//            if(nums[m] >= target){
//                r = m;
//            }else{
//                l = m + 1;
//            }
//        }
//        return nums[l] >= target ? l : -1;
//    }

    //方法3 滑动窗口
    public static int minSubArrayLen(int target, int[] nums){
        int l = 0, r = 0, len = nums.length, ans = Integer.MAX_VALUE, count = 0;
        while(r < len){
            count += nums[r];

            while(count >= target){
                ans = Math.min(ans,r-l+1);
                count -= nums[l];
                l++;
            }
            r++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        int arr[] = {2,3,1,2,4,3};
        int i = minSubArrayLen(7, arr);
    }
}
