package 图.找到冠军II;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int findChampion(int n, int[][] edges) {
        if(n == 1)return 0;
        if(edges.length == 0)return -1;
        int res = -1;
        Set<Integer> sr = new HashSet<>();
        for(int[] arr: edges){
            int l = arr[0];
            int r = arr[1];
            sr.add(r);
        }
        for(int i = 0; i < n; i ++){
            if(!sr.contains(i)){
                if(res != -1)return -1;
                res = i;
            }
        }
        return res;
    }
}
