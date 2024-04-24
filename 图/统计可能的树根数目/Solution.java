package 图.统计可能的树根数目;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private static int res;
    public static int rootCount(int[][] edges, int[][] guesses, int k) {
        int ans = 0;
        int n = edges.length;
        List<Integer>[] g = new List[n+1];
        Arrays.setAll(g, e->new ArrayList<>());
        for(int[] e : edges){
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        List<Integer>[] guessMap = new List[n+1];
        Arrays.setAll(guessMap, e->new ArrayList<>());
        for(int[] e : guesses){
            guessMap[e[0]].add(e[1]);
            //guessMap[e[1]].add(e[0]);
        }
        for(int i = 0; i < n + 1; i ++){
            res = 0;
            dfs(g,guessMap,i,i);
            ans += res >= k ? 1 : 0;
        }
        return ans;
    }
    static void dfs(List<Integer>[] g, List<Integer>[] guessMap, int root, int lastNum){
        //首先判断当前节点上一个节点和当前节点是不是在guessMap里面
        //如果在，res++
        List<Integer> guessl = guessMap[lastNum];
        for(int i : guessl){
            if(i == root)res++;
        }
        List<Integer> gl = g[root];
        for(int i = 0; i < gl.size(); i ++){
            if(lastNum != gl.get(i)){
                dfs(g,guessMap,gl.get(i),root);
            }
        }
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1},{1,2},{2,3},{3,4}};
        int[][] guess = {{1,0},{3,4},{2,1},{3,2}};
        int i = rootCount(edges, guess, 1);
    }
}
