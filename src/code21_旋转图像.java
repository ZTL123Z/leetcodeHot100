public class code21_旋转图像 {
    //所以位于 i 行 j 列的元素，去到 j 行 n−1−i 列，即 (i,j)→(j,n−1−i)。
    //两次翻转等于一次旋转
    //(i,j) 转置 --> (j,i) 行翻转 --> (j,n−1−i)
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++){ // 遍历对角线下方元素, 两边交换
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        for (int[] row : matrix) {
            for (int j = 0; j < n/2 ; j++) {
                int tmp = row[j];
                row[j] = row[n - 1 - j];
                row[n - 1 - j] = tmp;
            }
        }
    }
}
