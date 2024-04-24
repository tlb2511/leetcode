package 回溯.组合;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static List<List<Integer>> combine(int n, int t) {
        int k = t;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        func(n,0,path,ans,0,k);
        return ans;
    }
    static void func(int n, int cur, List<Integer> path, List<List<Integer>> ans, int len, int k){
        if(len == k){
            ans.add(new ArrayList<>(path));
            //ans.add(path);
            return;
        }
        for(int i = cur + 1; i <= n - (k - len) + 1; i ++){
            path.add(i);
            func(n,i,path,ans,len+1,k);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> combine = combine(4, 2);
        System.out.println(combine);
    }
}
