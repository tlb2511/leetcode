package 二分查找.x的平方根;

public class Solution {
    int mySqrt(int x) {
        int l = 1, r = x;
        while(l <= r){
            int m = (l + r) >> 1;
            if(x/m == m){
                return m;
            }else if(x/m < m){
                r = m - 1;
            }else{
                l = m + 1;
            }
        }
        return l - 1;
    }
}
