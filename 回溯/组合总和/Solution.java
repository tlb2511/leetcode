package 回溯.组合总和;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        func(candidates,0,ans,new ArrayList<>(),0,target);
        return ans;
    }
    void func(int[] arr, int cur, List<List<Integer>> ans, List<Integer> path, int res, int t){
        if(res == t){
            ans.add(new ArrayList<>(path));
            return;
        }else if(res > t){
            return;
        }
        for(int i = cur; i < arr.length; i ++){
            if(arr[i] > t)break;
            path.add(arr[i]);
            res += arr[i];
            func(arr,i,ans,path,res,t);
            res -= arr[i];
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        String s1 = "abc";
        System.out.println(s1);
        System.out.println(s1.hashCode());

        Class aClass = s1.getClass();
        try {
            Field value= aClass.getDeclaredField("value");
            //设置私有成员变量可访问
            value.setAccessible(true);
            //反射无法直接修改final修饰的成员变量
//          f.set(s1, "bcd");
            //获取String类value指向的地址，并赋值给o1
            char[] o1 = (char[])value.get(s1);
            //利用o1修改地址所指向的char数组
            o1[0] = 'b';
            System.out.println(s1);
            System.out.println(s1.hashCode());

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}