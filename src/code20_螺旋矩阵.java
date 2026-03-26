import java.util.ArrayList;
import java.util.List;

public class code20_螺旋矩阵 {
    //一定要把方向包装好，不然就写的代码就很复杂
    private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 右下左上

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ansList = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int i = 0, j = 0, di = 0;

        for (int k = 0; k < n * m; k++) {
            ansList.add(matrix[i][j]);
            matrix[i][j] = Integer.MAX_VALUE;
            int x = i + DIRS[di][0];
            int y = j + DIRS[di][1]; // 下一步的位置
            if (x < 0 ||x >= n || y < 0 || y >= m ||matrix[x][y] == Integer.MAX_VALUE) {
                di = (di + 1) % 4;
            }
            i += DIRS[di][0];
            j += DIRS[di][1];
        }

        return ansList;
    }
}
