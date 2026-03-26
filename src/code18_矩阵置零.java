public class code18_矩阵置零 {
//    用第一列的 matrix[i][0] 保存 rowHasZero[i]：
//
//    如果 i 行有 0，那么置 matrix[i][0]=0。
//    用第一行的 matrix[0][j] 保存 colHasZero[j]：
//
//    如果 j 列有 0，那么置 matrix[0][j]=0。


    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[] rawZero = new boolean[n];
        boolean[] colZero = new boolean[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matrix[i][j] == 0) {
                    rawZero[i] = true;
                    colZero[j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(rawZero[i] ||colZero[j]) {
                    matrix[i][j] = 0;
                }
            }
        }

    }
}
