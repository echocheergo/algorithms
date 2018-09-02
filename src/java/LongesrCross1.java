package java;

public class LongesrCross1 {
    public int largest(int[][] matrix) {
        // Write your solution here
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        node[][] res = new node[n][m];
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j ==0 || i == n - 1 || j == m - 1) {
                    if (matrix[i][j] == 1) {
                        res[i][j] = new node(1, 1, 1);
                    } else {
                        res[i][j] = new node(0,0,0);
                    }
                } else if (matrix[i][j] == 1) {
                    res[i][j] = new node(0,0,0);
                    int arm = Math.min(res[i-1][j].upArm, res[i][j-1].rightArm);
                    res[i][j].rightArm = res[i][j-1].rightArm + 1;
                    res[i][j].upArm = res[i-1][j].upArm + 1;
                    arm = Math.min(arm, check(matrix, i, j, arm, n, m));

                    res[i][j].length = arm + 1;
                    max = Math.max(max, res[i][j].length);

                } else {
                    res[i][j] = new node(0,0,0);
                    res[i][j].length = 0;
                }
            }
        }
        return max;
    }
    private int check(int[][] matrix, int i, int j, int arm, int n, int m) {
        int count = 0;
        int i2 = i + 1;
        int j2 = j + 1;
        while (arm > 0 && i2 < n && j2 < m) {
            if (matrix[i2][j] != 1|| matrix[i][j2] != 1) {
                return count;
            }
            arm--;
            i2++;
            j2++;
            count++;
        }
        return count;
    }
    private class node {
        int rightArm;
        int upArm;
        int length;
        node (int rightArm, int upArm, int length) {
            this.rightArm = rightArm;
            this.upArm = upArm;
            this.length = length;
        }
    }
}
