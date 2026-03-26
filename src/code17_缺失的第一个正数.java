public class code17_缺失的第一个正数 {
    //对于一个长度为 N 的数组，其中没有出现的最小正整数只能在 [1,N+1] 中
    //由于我们只在意 [1,N] 中的数，因此我们可以先对数组进行遍历，把不在 [1,N] 范围内的数修改成任意一个大于 N 的数（例如 N+1）。这样一来，数组中的所有数就都是正数了
    //只能使用常数级别的额外空间，在这个限制下本题的思路有一个非正式的名称：原地哈希。
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            // nums[i] != nums[nums[i] - 1]的意思是，当前的数不符合当前的哈希的算法，i是2，那就要nums[i] = 3
            // 为什么用while，因为交换数组可以会让后面的一个符合，而不是前面的符合，所以有可能交换两次
            while (nums[i] > 0 && nums[i] <= len && nums[i] != nums[nums[i] - 1] ) {
                // 满足在指定范围内、并且没有放在正确的位置上，才交换
                // 例如：数值 3 应该放在索引 2 的位置上
                swap(nums, nums[i] - 1, i);
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        // 都正确则返回数组长度 + 1
        return len + 1;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
