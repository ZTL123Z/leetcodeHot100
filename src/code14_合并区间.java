import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class code14_合并区间 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][2];
        // 按照每个数组的第一个数排序，从小到大
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> merged = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 ||merged.get(merged.size() - 1)[1] < L){
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
//        第一个 [] 写大小：merged.size()
//        第二个 [] 表示里面存的是 int[]
        return merged.toArray(new int[merged.size()][]);
    }
}
