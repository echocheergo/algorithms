package javasrc;

import java.util.LinkedList;
//Flood filling using DFS or BFS
public class UberNumberOfIslands {
    public int numIslands(char[][] grid) {
        int r = grid.length;
        if (r == 0) {
            return 0;
        }
        int c = grid[0].length;
        int count = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1') {
                    BFS(grid, r, c, i, j);
                    //DFS(grid, r, c, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    //DFS faster for small grid??
    private void DFS(char[][] grid, int r, int c, int i, int j) {
        if (i >= 0 && j >= 0 && i < r && j < c && grid[i][j] == '1') {
            grid[i][j] = '0';
            DFS(grid, r, c, i+1, j);
            DFS(grid, r, c, i-1, j);
            DFS(grid, r, c, i, j+1);
            DFS(grid, r, c, i, j-1);

        }
    }
    private void BFS(char[][] grid, int r, int c, int i, int j) {
        grid[i][j] = '0';
        int code = i * c + j;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(code);
        while (!queue.isEmpty()) {
            int curCode = queue.poll();
            int n = curCode / c;
            int m = curCode % c;
            // go up
            if (n > 0 && grid[n-1][m] == '1') {
                queue.offer((n-1)*c + m);
                grid[n-1][m] = '0';
            }
            // go down
            if (n < r - 1 && grid[n+1][m] == '1') {
                queue.offer((n+1)*c + m);
                grid[n+1][m] = '0';
            }
            // go left
            if (m > 0 && grid[n][m - 1] == '1') {
                queue.offer(n * c + m - 1);
                grid[n][m - 1] = '0';
            }
            // go right
            if (m < c - 1 && grid[n][m + 1] == '1') {
                queue.offer(n * c + m + 1);
                grid[n][m + 1] = '0';
            }
        }
    }
}
