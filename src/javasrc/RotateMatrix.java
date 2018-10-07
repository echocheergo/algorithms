package javasrc;
// mirror y; mirror Y = X, careful for index bound
public class RotateMatrix {
    public void rotate(int[][] matrix) {
        // Write your solution here
        if (matrix.length <= 1) {
            return;
        }
        mirrorY(matrix);
        mirrorYEX(matrix);
        return;
    }
    private void mirrorY(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length / 2; j++) {
                swap(matrix, i, j, i, matrix.length - j - 1);
            }
        }
        return;
    }
    private void mirrorYEX(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length - i - 1; j++) {
                swap(matrix, i, j, matrix.length - j - 1, matrix.length - i - 1);
            }
        }
        return;
    }
    private void swap(int[][] matrix, int i , int j, int m, int n) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[m][n];
        matrix[m][n] = tmp;
    }
}
