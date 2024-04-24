package 图.受限条件下可到达节点的数目;

import java.util.*;

public class Solution {
    private int ans = 0;
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, e->new ArrayList<>());
        for(int[] e : edges){
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        Set<Integer> set = new HashSet<>();
        for(int i : restricted){
            set.add(i);
        }
        func(g,set,0,-1);
        return ans + 1;
    }
    void func(List<Integer>[] g, Set<Integer> set, int cur, int last){
        List<Integer> list = g[cur];
        for(int i : list){
            if(i != last && !set.contains(i)){
                func(g,set,i,cur);
                ans++;
            }
        }
    }
    public static void main(String[] args) {
        int x = 1;
        System.out.println(x);
        //f(x);
        System.out.println(x);
    }
}
