package 二分查找.H指数;

import java.util.Arrays;
import java.util.Collections;

public class Solution {
    //方法1 直接排序，然后二分搜索
//    public static int hIndex(int[] citations) {
//        Arrays.sort(citations);
//        int n = citations.length;
//        int l = 1, r = n;
//        while(l <= r){
//            int m = (l + r) >>> 1;
//            if(citations[n - m] >= m){
//                l = m + 1;
//            }else{
//                r = m - 1;
//            }
//        }
//        return l-1;
//    }



    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int l = 1, r = n;
        while(l < r){
            int m = (l + r) >>> 1;
            if(citations[n-m] >= m){
                l = m + 1;
            }else{
                r = m - 1;
            }
        }
        return l - 1;
    }





























}
