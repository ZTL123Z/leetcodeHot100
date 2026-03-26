import java.util.ArrayList;
import java.util.List;

public class code19_螺旋矩阵 {


    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> ls =  spiralOrder(matrix);
        System.out.println(ls.toString());
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ansList = new ArrayList<>();
        int cnt = 0;
        int i = 0, j = 0;
        boolean[][] isZero = new boolean[matrix.length][matrix[0].length];
        while(cnt < matrix.length * matrix[0].length) {

            while( !isZero[i][j] && j <  matrix[0].length - 1) {
                ansList.add(matrix[i][j]);
                isZero[i][j] = false;
                j++;
                cnt++;
            }
            ansList.add(matrix[i][j]);
            isZero[i][j] = false;
            cnt++;
            i++;
            while( !isZero[i][j] && i <  matrix.length - 1) {
                ansList.add(matrix[i][j]);
                isZero[i][j] = false;
                i++;
                cnt++;
            }
            ansList.add(matrix[i][j]);
            isZero[i][j] = false;
            cnt++;
            j--;
            while( !isZero[i][j] && j > 0) {
                ansList.add(matrix[i][j]);
                isZero[i][j] = false;
                j--;
                cnt++;
            }
            ansList.add(matrix[i][j]);
            isZero[i][j] = false;
            cnt++;
            i--;
            while( !isZero[i][j] && i > 0) {
                ansList.add(matrix[i][j]);
                isZero[i][j] = false;
                i--;
                cnt++;
            }
            ansList.add(matrix[i][j]);
            isZero[i][j] = false;
            cnt++;
            i++;
        }

        return ansList;
    }
}
