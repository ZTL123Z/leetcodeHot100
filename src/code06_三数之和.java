import java.util.*;
import java.util.stream.Collectors;

public class code06_三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        int Len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); //排序可用
        for(int i = 0; i < Len; i++){
            if(nums[i] > 0) break; //如果当前数大于0，说明后面的数都大于0，不可能有三数之和为0
            if(i > 0 && nums[i] == nums[i - 1]) continue;  //如果当前数和前一个数相同，说明已经遍历过了，跳过，并且第一个数不检查
            int R = Len - 1;
            int L = i + 1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while(L < R && nums[L] == nums[L + 1]) L++; //跳过重复的数， 用while
                    while(L < R && nums[R] == nums[R - 1]) R--; //跳过重复的数
                    L++; //移动左指针
                    R--; //移动右指针
                }
                else if (sum < 0) L++; //不要忘了移动
                else R--;
            }
        }
        return res;
    }
}
