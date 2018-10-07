package javasrc;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<List<Integer>> nqueens(int n) {
        // 1.validate each queen position in O(n) time
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<>();
        nQueens(n, res, cur);
        return res;
    }
    private void nQueens(int n, List<List<Integer>> res, List<Integer> cur) {
        if (cur.size() == n) {
            res.add(new ArrayList<Integer>(cur)); // add list to list<list> has to copy otherwise point to the same
            return;
        }
        // check each row for valid position, for each valid position, branch out
        for (int i = 0; i < n; i++) {
            if (check(i, cur)) {
                cur.add(i);
                nQueens(n, res, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }
    private boolean check(int column, List<Integer> cur) {
        int row = cur.size();
        for (int i = 0; i < row; i++) {
            if (cur.get(i) == column || Math.abs(cur.get(i) - column) == row - i) {
                return false;
            }
        }
        return true;
    }

    // 2. memorization
    /*public List<List<Integer>> nqueens(int n) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    int[] cur = new int[n];
    boolean[] usedCol = new boolean[n];
    boolean[] usedDia = new boolean[2*n - 1];
    boolean[] usedRevDia = new boolean[2*n - 1];
    nQueens(n, 0, cur, usedCol, usedDia, usedRevDia, res);
    return res;
}
    private void nQueens(int n, int row, int[] cur, boolean[] usedCol, boolean[] usedDia, boolean[] usedRevDia, List<List<Integer>> res) {
        if (row == n) {
            res.add(toList(cur));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (valid(n, row, i, usedCol, usedDia, usedRevDia)) {
                mark(n, row, i, usedCol, usedDia, usedRevDia);
                cur[row] = i;
                nQueens(n, row + 1, cur, usedCol, usedDia, usedRevDia, res);
                unmark(n, row, i, usedCol, usedDia, usedRevDia);
            }
        }
    }

    private boolean valid(int n, int row, int column, boolean[] usedCol, boolean[] usedDia, boolean[] usedRevDia) {
        return (!usedCol[column] && !usedDia[column + row] && !usedRevDia[column - row + n - 1]);
    }

    private void mark(int n, int row, int column, boolean[] usedCol, boolean[] usedDia, boolean[] usedRevDia) {
        usedCol[column] = true;
        usedDia[column + row] = true;
        usedRevDia[column - row + n - 1] = true;
    }

    private void unmark(int n, int row, int column, boolean[] usedCol, boolean[] usedDia, boolean[] usedRevDia) {
        usedCol[column] = false;
        usedDia[column + row] = false;
        usedRevDia[column - row + n - 1] = false;
    }

    private List<Integer> toList(int[] cur) {
        List<Integer> res = new ArrayList<>();
        for (int n : cur) {
            res.add(n);
        }
        return res;
    }*/
}
