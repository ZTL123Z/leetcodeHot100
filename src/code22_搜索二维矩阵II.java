public class code22_搜索二维矩阵II {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int i = 0;
        int j = m - 1;

        while(i < n && j >= 0) {
            if (target == matrix[i][j]) {
                return true;
            }
            if(matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }

        return false;
    }
}
