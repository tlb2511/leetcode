package 数组.拿出最少数目的魔法豆;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    public long minimumRemoval(int[] beans) {
        long c = 0;
        Arrays.sort(beans);
        long res = Long.MAX_VALUE;
        int j = beans.length;
        for(int i = 0; i < beans.length; i ++){
            c += beans[i];
        }
        for(int i = 0; i < j; i ++){
            res = Math.min(res, c - beans[i] * (j - i));
        }
        return res;
    }
}
