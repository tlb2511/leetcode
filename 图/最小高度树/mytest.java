package 图.最小高度树;

import java.util.*;

public class mytest {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer>[] g = new List[n];
        for(int i = 0; i < n; i ++){
            g[i] = new ArrayList<>();
        }
        int[] d = new int[n];
        for(int[] arr : edges){
            g[arr[0]].add(arr[1]);
            g[arr[1]].add(arr[0]);
            d[arr[0]]++;
            d[arr[1]]++;
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < n; i ++){
            if(d[i] == 1){
                queue.addLast(i);
                d[i] = 0;
            }
        }
        n -= queue.size();
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i = 0; i < len; i ++){
                int top = queue.removeFirst();
                for (Integer neb : g[top]) {
                    d[neb]--;
                    if(d[neb] == 1){
                        queue.addLast(neb);
                    }
                }
            }
            n -= queue.size();
            if(n == 0)break;
        }
        List<Integer> ans = new ArrayList<>();
        for(Integer i : queue){
            ans.add(i);
        }
        return ans;

    }
}
