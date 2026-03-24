import java.util.HashMap;
import java.util.Map;

public class code10_和为K的子数组 {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; i++){
            s[i + 1] = s[i] + nums[i];
        }

        Map<Integer, Integer> cnt = new HashMap<>(n + 1, 1);
        int ans = 0;
        for (int sj: s) {
            ans += cnt.getOrDefault(sj -k, 0); //有就加上前面有多少个可以达到这个数的前缀和数组，没有就是0
            cnt.merge(sj, 1, Integer::sum); //cnt[s]++

        }
        return ans;
    }
}
