public class code15_轮转数组 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; i++) {
            newArr[(i + k) % n] = nums[i];
        }
//        System.arraycopy(
//                newArr,   // 源数组：从哪里拷贝
//                0,        // 源数组起始位置：从第 0 个开始
//                nums,     // 目标数组：拷贝到哪里
//                0,        // 目标数组起始位置：从第 0 个开始放
//                n         // 一共拷贝多少个：n 个元素
//        );
        System.arraycopy(newArr, 0, nums, 0, n);
    }
}
