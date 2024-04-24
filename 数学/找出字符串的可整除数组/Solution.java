package 数学.找出字符串的可整除数组;


/*
* （a*10 + b）mod c  ==  (a mod c * 10 + b)mod c
*
* */
public class Solution {
    public int[] divisibilityArray(String word, int m) {
        int n = word.length();
        int[] ans = new int[n];
        //因为m最大为10的九次方，如果用int的话，可能会使last 超过int最大值
        long last = 0;
        for(int i = 0; i < n; i ++){
            last = (last*10 + (word.charAt(i) - '0')) % m;

            ans[i] = last == 0 ? 1 : 0;
        }
        return ans;
    }
}
