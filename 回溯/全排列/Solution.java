package 回溯.全排列;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        func(nums,new ArrayList<>(),ans,new HashSet<>(),0);
        return ans;
    }
    void func(int[] arr, List<Integer> path, List<List<Integer>> ans, Set<Integer> visit, int len){
        if(len == arr.length){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < arr.length; i ++){
            if(!visit.contains(i)){
                visit.add(i);
                path.add(arr[i]);
                func(arr,path,ans,visit,len+1);
                path.remove(path.size()-1);
                visit.remove(i);
            }
        }
    }
}
