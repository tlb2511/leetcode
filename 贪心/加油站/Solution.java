package 贪心.加油站;

public class Solution {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length, i = 0;
        while(i < n){
            int sumGas = 0, cnt = 0, j = i;
            while(cnt < n){
                sumGas += gas[i];
                if(sumGas < cost[j]){
                    break;
                }
                sumGas -= cost[j];
                cnt++;
                j = (j+cnt+1)%n;
            }
            if(cnt == n)return i;
            i = i + cnt + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas = {2,3,4};
        int[] cost = {3,4,2};
        int i = canCompleteCircuit(gas, cost);
    }

}
