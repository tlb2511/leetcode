package 数组.删除有序数组中的重复项;

public class Solution {
//    public static int removeDuplicates(int[] nums) {
//        if(nums.length <= 1)return nums.length;
//        int l = 0;
//        for(int r = 0; r < nums.length; r ++){
//            if(nums[r] != nums[l]){
//                nums[l+1] = nums[r];
//                l++;
//            }
//        }
//        return l + 1;
//    }
    public static int removeDuplicates(int[] nums){
        int len = nums.length;
        if(len <= 1)return len;
        int low = 1, fast = 1;
        while(fast < len){
            if(nums[fast] != nums[low]){
                nums[low] = nums[fast];
                low++;
            }
            fast++;
        }
        return low;
    }
    public static void main(String[] args) {
        int arr[] = {0,0,1,2,2,3};
        int i = removeDuplicates(arr);
    }
}
