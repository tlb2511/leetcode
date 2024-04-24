package 数组.找出美丽数组的最小和;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    //超时
//    public static int minimumPossibleSum(int n, int target) {
//        int ans = 0;
//        Set<Integer> set = new HashSet<>();
//        int i = 1, len = 0;
//        while(len < n){
//            if(!set.contains(target-i)){
//                ans += i;
//                ans = ans%(1000000007) ;
//                set.add(i);
//                len++;
//            }
//            i++;
//        }
//        return ans;
//    }
    public static int minimumPossibleSum(int n, int k){
        int m = Math.min(k/2,n);
        return (m*(m+1) + (2*k + n - m - 1)*(n-m))/2 %1000000007;
    }
    public static void main(String[] args) {
        int i = minimumPossibleSum(3, 3);
        System.out.println(i);
    }
}
