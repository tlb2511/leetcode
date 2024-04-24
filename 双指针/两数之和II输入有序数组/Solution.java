package 双指针.两数之和II输入有序数组;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int l = 0, r = n-1;
        while(l < r){
            if(numbers[l] + numbers[r] == target)return new int[]{l,r};
            else if(numbers[l] + numbers[r] < target){
                l++;
            }else{
                r--;
            }
        }
        return new int[]{0,0};
    }
}
