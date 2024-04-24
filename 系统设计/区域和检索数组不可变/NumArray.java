package 系统设计.区域和检索数组不可变;

import java.util.ArrayList;
import java.util.List;

public class NumArray {
    private List<Integer> preSum = new ArrayList<>();
    public NumArray(int[] nums) {
        preSum.add(0);
        for(int n : nums){
            int temp = preSum.get(preSum.size()-1) + n;
            preSum.add(temp);
        }
    }

    public int sumRange(int left, int right) {
        return preSum.get(right+1) - preSum.get(left);
    }
}
