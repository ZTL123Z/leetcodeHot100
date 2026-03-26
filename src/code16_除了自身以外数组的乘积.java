public class code16_除了自身以外数组的乘积 {
    /*
    创建了左右两边的乘积列表，前缀和后缀
     */
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;

        //L和R是左右的两边的乘积列表
        int[] L = new int[len];
        int[] R = new int[len];

        int[] answer = new int[len];

        L[0] = 1;
        for (int i = 1; i < len; i++) {
            L[i] = nums[i - 1] * L[i - 1];
        }
        R[len - 1] = 1;
        for (int i = len - 2; i >=0 ; i--) {
            R[i] = nums[i + 1] * R[i + 1];
        }

        for (int i = 0; i < len; i++) {
            answer[i] = L[i] * R[i];
        }

        return answer;
    }
}
