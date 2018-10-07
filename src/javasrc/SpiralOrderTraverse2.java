package javasrc;

import java.util.ArrayList;
import java.util.List;
// NM matrix
public class SpiralOrderTraverse2 {
    public List<Integer> spiral(int[][] matrix) {
        // Write your solution here

        List<Integer> res = new ArrayList<>();
        spiral( matrix[0].length, matrix.length, matrix, res, 0);
        return res;
    }
    private void spiral(int width, int length, int[][] matrix, List<Integer> res, int offset) {
        // base case
        if (width <= 1 || length <= 1) {
            if (width == 1 && length == 1) {
                res.add(matrix[offset][offset]);
            } else if (width == 1 && length > 1) {
                for (int i = 0; i < length; i++) {
                    res.add(matrix[offset + i][offset]);
                }
            } else if (length == 1 && width > 1) {
                for (int i = 0; i < width; i++) {
                    res.add(matrix[offset][offset + i]);
                }
            }
            return;
        }
        // top
        for (int i = 0; i < width - 1; i++) {
            res.add(matrix[0 + offset][offset + i]);
        }
        // right
        for(int i = 0; i < length - 1; i++) {
            res.add(matrix[offset + i][matrix[0].length - offset - 1]);
        }
        // bottom
        for(int i = 0; i < width - 1; i++) {
            res.add(matrix[matrix.length - offset - 1][ matrix[0].length - 1 - offset - i]);
        }
        // left
        for(int i = 0; i < length - 1; i++) {
            res.add(matrix[matrix.length - offset - 1 - i][offset]);
        }
        spiral(width - 2, length - 2, matrix, res, offset + 1);
    }
}


