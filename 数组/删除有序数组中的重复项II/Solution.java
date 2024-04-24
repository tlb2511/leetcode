package 数组.删除有序数组中的重复项II;

public class Solution {
    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len <= 2)return len;
        int low = 2, fast = 2;
        while(fast < len){
            if(nums[fast] != nums[low - 2]){
                nums[low] = nums[fast];
                low++;
            }
            fast++;
        }
        return low;
    }
    //可以扩展为允许有K个重复的数字
    public static int removeDuplicatesOfK(int[] nums, int k) {
        int len = nums.length;
        if(len <= k)return len;
        int low = k, fast = k;
        while(fast < len){
            if(nums[fast] != nums[low - k]){
                nums[low] = nums[fast];
                low++;
            }
            fast++;
        }
        return low;
    }
    public static void main(String[] args) {
        int arr[] = {0,0,0,0,1,1,1,2,2,3,4,4,4};
        int i = removeDuplicatesOfK(arr,3);
    }
}