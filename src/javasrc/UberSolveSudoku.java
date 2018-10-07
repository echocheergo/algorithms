package javasrc;

import java.util.ArrayList;
import java.util.List;

public class UberSolveSudoku {
    // three matrix: each use an int
    // for each cell, record the num in each matrix, if not filled then record its id (9x + y)
    // for each empty cell and possible candidate num, dfs
    // a & (-a) get last bit; a|= bit: set; a -= bit afterwards to reset
    public void solveSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[][] subs = new int[3][3];
        List<Integer> miss = new ArrayList<>();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    rows[i] |= (1 << num);
                    cols[j] |= (1 << num);
                    subs[i / 3][j / 3] |= (1 << num);
                } else {
                    miss.add(i * 9 + j);
                }
            }
        }
        help(board, rows, cols, subs, miss, 0);
    }

    // return true if already find the result
    private boolean help(char[][] board, int[] rows, int[] cols, int[][] subs,
                         List<Integer> miss, int start) {
        if (start == miss.size()) {
            return true;
        }
        int index = miss.get(start);
        int y = index / 9;
        int x = index % 9;
        int full = (1 << 9) - 1;
        int cand = full ^ (rows[y] | cols[x] | subs[y / 3][x / 3]);// all possible candidates we can use
        while (cand > 0) {
            int bit = cand & (-cand);// last 1 bit
            cand -= bit;// since we have used it, we remove this bit
            rows[y] |= bit;
            cols[x] |= bit;
            subs[y / 3][x / 3] |= bit;
            if (help(board, rows, cols, subs, miss, start + 1)) {// if this is the answer, we change the position to correponding number, and return true
                int num = 1 + (int)(Math.log(bit) / Math.log(2));
                board[y][x] = (char)(num + '0');
                return true;
            }
            rows[y] -= bit;
            cols[x] -= bit;
            subs[y / 3][x / 3] -= bit;
        }
        return false;
    }
}
