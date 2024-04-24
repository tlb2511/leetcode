package 树.使二叉树所有路径值相等的最小代价;

public class Solution {
    //方法1 第一次DFS从下往上，记录每个节点的最大值  第二次DFS从上往下，计算当前节点应该增加的值
//    public static int minIncrements(int n, int[] cost) {
//        int[] arr = new int[n];
//        dfs(n,cost,arr,0);
//        int mx = arr[0];
//        int ans = 0;
//        return func(n,cost,arr,0,mx);
//    }
//
//    static void dfs(int n, int[] cost, int[] arr, int i){
//        if(i >= n)return;
//        dfs(n,cost,arr,2*i+1);
//        dfs(n,cost,arr,2*i+2);
//        arr[i] = cost[i];
//        if(2*i+2 < n){
//            arr[i] += Math.max(arr[2*i+1],arr[2*i+2]);
//        }
//    }
//
//    static int func(int n, int[] cost, int[] arr, int i, int mx){
//        if(i >= n)return 0;
//        //arr[i] - cost[i] - arr[]
//        int ans = 0;
//        ans += mx - arr[i];
//        arr[i] += ans;
//        return func(n,cost,arr,2*i+1,arr[i] - cost[i] - ans) + func(n,cost,arr,2*i+2,arr[i] - cost[i] - ans) + ans;
//    }

    //方法2
    public static int minIncrements(int n, int[] cost){
        int ans = 0;
        for(int i = (n-2)/2; i >= 0; i--){
            ans += Math.abs(cost[2 * i + 1] - cost[2 * i + 2]);
            cost[i] += Math.max(cost[2 * i + 1],cost[2 * i + 2]);
        }
        return ans;
    }



    public static void main(String[] args) {
        int arr[] = new int[]{1,5,2,2,3,3,1};
        int i = minIncrements(7, arr);
        int t = 3;
        temp(t);
        System.out.println(i);
    }

    static void temp(int x){
        x = 5;
    }
}
