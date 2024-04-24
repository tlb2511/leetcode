package 数组.多数元素;

import java.util.HashMap;
import java.util.Map;

public class Solution {
//    public static int majorityElement(int[] nums) {
//        if(nums.length == 1)return nums[0];
//        Map<Integer,Integer> map = new HashMap<>();
//        int i = 0;
//        for(i = 0; i <nums.length; i ++){
//            if(map.containsKey(nums[i])){
//                //int v = map.get(nums[i]);
//                //map.get(nums[i]) = map.get(nums[i])+1;
//                map.put(nums[i],map.get(nums[i])+1);
//                if(map.get(nums[i]) > nums.length/2){
//                    break;
//                }
//            }else{
//                map.put(nums[i],1);
//            }
//        }
//        return nums[i];
//    }
    /*摩尔投票法*/
    public static int majorityElement(int[] nums){
        int votes = 0, v = 0;
        for(int num : nums){
            if(votes == 0){
                v = num;
            }
            votes += num == v ? 1 : -1;
        }
        return v;
    }
    public static void main(String[] args) {
        int arr[] = {1,1,2,2,2,3,3,3,3,3};
        int i = majorityElement(arr);
    }
}
