package 二分查找.完成旅途的最少时间;

public class Solution {
    public static long minimumTime(int[] time, int totalTrips) {
        int mn = Integer.MAX_VALUE;
        for(int i : time){
            mn = Math.min(i,mn);
        }
        //if(mn > totalTrips)return mn;
        long l = 1 , r = (long)(totalTrips * mn);
        while(l < r){
            long m = (l+r) >>> 1;
            if(func(time,m,totalTrips)){
                r = m;
            }else{
                l = m + 1;
            }
        }
        return r;
    }
    private static boolean func(int[] time, long t, int key){
        int ans = 0;
        for(int i : time){
            ans += t/i;
            if(ans >= key)break;
        }
        return ans >= key;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2};
        long l = minimumTime(arr, 1);
        System.out.println(l);
    }
}
