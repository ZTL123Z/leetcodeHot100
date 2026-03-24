import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class code03_最长连续序列 {
    public int longestConsecutive(int[] nums) {
        int max_len = nums.length > 0 ? 1 : 0;
        HashSet<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new));
        for (Integer i : set) {
            if(!set.contains(i-1)){
               int len = 1;
               while(set.contains(i+len)){ //找到一个启动点，开始计算连续序列的长度
                   len++;
                   max_len = Math.max(max_len, len);
               }
            }
        }
        return max_len;
    }
}
