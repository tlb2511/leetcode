package 图.统计树中的合法路径数目;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private final static int mx = (int)1e5;
    private final static boolean[] isPrime = new boolean[mx+1];//质数是false，非质数是true
    static{
        isPrime[1] = true;
        for(int i = 2; i*i <= mx; i++){
            if(!isPrime[i]){
                for(int j = i*i; j <= mx; j+=i){
                    isPrime[j] = true;
                }
            }
        }
    }

    public long countPaths(int n, int[][] edges) {
        //记录所有节点的邻居节点
        List<Integer>[] arr = new ArrayList[n+1];
        Arrays.setAll(arr, e -> new ArrayList<>());
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            arr[x].add(y);
            arr[y].add(x);
        }
        //遍历质数节点
        long ans = 0;
        int[] sizes = new int[n+1];
        List<Integer> nodes = new ArrayList<>();
        for(int i = 1; i <= n; i ++){

            if(isPrime[i])continue;
            int sum = 0;
            for(int cur : arr[i]){

                if(!isPrime[cur])continue;;

                if(sizes[cur] == 0){
                    nodes.clear();
                    dfs(cur,-1,arr,nodes);
                    for(int node : nodes){
                        sizes[node] = nodes.size();
                    }
                }
                ans += (long)sum*sizes[cur];
                sum += sizes[cur];
            }
            ans += sum;
        }
        return ans;
    }

    public void dfs(int cur, int last, List<Integer>[] arr, List<Integer> nodes){
        nodes.add(cur);
        for(int x : arr[cur]){
            if(x != last && isPrime[x]){
                dfs(x,cur,arr,nodes);
            }
        }
    }
}
