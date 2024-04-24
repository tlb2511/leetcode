package 图.最小高度树;

import java.util.*;

public class Solution {
    //遍历每个节点，用bfs搜索记录最短高度，时间复杂度太高，超时
//    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
//        List<Integer> ans = new ArrayList<>();
//        int maxLength = Integer.MAX_VALUE;
//        Map<Integer,List<Integer>> map = new HashMap<>();
//        Deque<Integer> queue = new ArrayDeque<>();
//
//        for(int i = 0 ; i < edges.length; i ++){
//            int key = edges[i][0];
//            int value = edges[i][1];
//            if(map.containsKey(key)){
//                map.get(key).add(value);
//            }else{
//                List<Integer> temp = new ArrayList<>();
//                temp.add(value);
//                map.put(key, temp);
//            }
//            if(map.containsKey(value)){
//                map.get(value).add(key);
//            }else{
//                List<Integer> temp = new ArrayList<>();
//                temp.add(key);
//                map.put(value, temp);
//            }
//        }
//        for(int i = 0; i < n; i ++){
//            queue.addLast(i);
//            int count = -1;
//            Set<Integer> set = new HashSet<>();
//            while(!queue.isEmpty()){
//                int len = queue.size();
//                for(int j = 0; j < len; j ++){
//                    int node = queue.removeFirst();
//                    set.add(node);
//                    List<Integer> ls = map.get(node);
//                    if(ls != null){
//                        for(int k = 0; k < ls.size(); k ++){
//                            if(!set.contains(ls.get(k))){
//                                queue.addLast(ls.get(k));
//                            }
//                        }
//                    }
//                }
//                count++;
//            }
//            if(count < maxLength){
//                maxLength = count;
//                ans.clear();
//                ans.add(i);
//            }else if(count == maxLength){
//                ans.add(i);
//            }
//        }
//        return ans;
//    }

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        if(n == 1){
            ans.add(0);
            return ans;
        }
        //degree记录每个节点的度
        int degree[] = new int[n];
        //map存放每个节点的相邻节点
        List<List<Integer>> map = new ArrayList<>();
        //为每个节点的相邻节点为分配内存空间
        for(int i = 0; i < n; i ++){
            map.add(new ArrayList<>());
        }
        //记录每个节点的度
        //记录每个节点的相邻节点
        for(int i = 0; i < edges.length; i ++){
            int key = edges[i][0];
            int value = edges[i][1];
            degree[key]++;
            degree[value]++;
            map.get(key).add(value);
            map.get(value).add(key);
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < n; i ++){
            if(degree[i] == 1){
                queue.addLast(i);
            }
        }
        while(!queue.isEmpty()){
            ans = new ArrayList<>();
            int len = queue.size();
            for(int i = 0; i < len; i ++){
                int node = queue.removeFirst();
                degree[node] = 0;
                ans.add(node);
                List<Integer> neighbors = map.get(node);
                for(int val : neighbors){
                    degree[val]--;
                    if(degree[val] == 1){
                        queue.addLast(val);
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[][] = {{3,0},{3,1},{3,2},{3,4},{5,4}};
        List<Integer> minHeightTrees = findMinHeightTrees(6, arr);
    }
}
