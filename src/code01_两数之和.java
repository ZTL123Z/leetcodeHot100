import java.util.HashMap;
import java.util.Map;

public class code01_两数之和 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){ //键是数值，值是索引
            if(map.containsKey(target - nums[i])){ //如果map中包含target - nums[i]，说明已经找到
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
