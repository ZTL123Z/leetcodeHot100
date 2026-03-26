import java.util.Arrays;

public class code13_最大子数组和 {
    /*
    维护一个窗口和一个最大的变量。
    从左往右，如果遇到一个数比之前全部的数之和都大，就从这个数重新开始
    max_sum负责记录在过程中最大的数
     */
    public int maxSubArray(int[] nums) {
        int cur_sum = nums[0], max_sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            cur_sum = Math.max(nums[i], cur_sum + nums[i]);
            max_sum = Math.max(max_sum, cur_sum);
        }

        return max_sum;
    }
}
