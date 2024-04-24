package 二分查找.猜数字大小;

public class Solution {
    public int guessNumber(int n) {
        int l = 1, r = n, m = 0, v = 0;
        while(l <= r){
            m = (l + r) >>> 1;//>>有符号右移 >>>无符号右移
            v = guess(m);
            if(v == 0){
                return m;
            }
            else if(v == 1){
                l = m + 1;
            }else if(v == -1){
                r = m - 1;
            }
        }
        return -1;
    }
    public int guess(int n){
        if(n < 10){
            return -1;
        }else if(n == 10){
            return 0;
        }
        return 1;
    }
}
