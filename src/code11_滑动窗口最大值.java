import java.util.PrimitiveIterator;
import java.util.PriorityQueue;

public class code11_滑动窗口最大值 {
    /*
     * 1.维护一个优先队列 pq，pq 中存储的是 (nums[i], i) 这样的元组
     * 2.维护一个 ans[] 数组，用于记录当前窗口内的最大值
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        int ans[] = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
            // 关键：清理堆顶 不在当前窗口内 的过期元素
            // 窗口范围：[i-k+1, i]，下标 <= i-k 就是过期了
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }
}
