public class code07_接雨水 {
    public int trap(int[] height) {
        int sum = 0;
        int len = height.length;
        int[] max_left = new int[len];
        int[] max_right = new int[len];

        for(int i = 1; i < len - 1; i++){ //从左到右遍历，记录每个位置左边的最大值
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        }
        for(int i = len - 2; i >= 0; i--){ //从右到左遍历，记录每个位置右边的最大值
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        for(int i = 1; i < len - 1; i++){ //从左到右遍历，计算每个位置的接水量
            int min = Math.min(max_left[i], max_right[i]);
            if(min > height[i]) sum += min - height[i];
        }
        return sum;
    }
}
