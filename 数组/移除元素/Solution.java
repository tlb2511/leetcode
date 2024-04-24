package 数组.移除元素;

public class Solution {
//    public static int removeElement(int[] nums, int val) {
//        int l = 0, r = 0, len = nums.length;
//
//        while(l < len){
//            if(nums[l] == val){
//                r = l + 1;
//                while(r < len){
//                    if(nums[r] != val){
//                        nums[l] = nums[r];
//                        nums[r] = val;
//                        break;
//                    }else{
//                        r++;
//                    }
//                }
//                if(r == len)break;
//            }
//            l++;
//        }
//        return l;
//    }
    public static int removeElement(int[] nums, int val){
        int l = 0;
        for(int j = 0; j <nums.length; j ++){
            if(nums[j] != val){
                nums[l++] = nums[j];
            }
        }
        return l;
    }
    public static void main(String[] args) {
        int arr[] = {0,1,2,2,3,0,4,2};
        int i = removeElement(arr, 2);
    }
}
