package oa;

import java.util.*;

public class IndeedOA18 {
    // baoli jiefa: scan all for all; use a [][] to store temp and global res for final result
    public static int IndeedOA181(int H, int W, int[][] dots) {
        int[][] grid = new int[H][W];
        int res = 0;

        for (int i = 0; i < dots.length; i++) {
            int x = dots[i][0];
            int y = dots[i][1];
            int darkness = dots[i][2];

            // scan all cells to see if update or not
            for (int j = 0; j < H; j++) {
                for (int k = 0; k < W; k++) {
                    int newDarkness = darkness - Math.abs(x - j) - Math.abs(y - k);
                    if (newDarkness > grid[j][k]) {
                        res += newDarkness - grid[j][k];
                        grid[j][k] = newDarkness;

                    }
                }
            }
        }
        return res;
    }

    //DFS: scan + then dfs on diagonal
    // sort first
    public int IndeedOA182(int H, int W, int[][] dots) {
        int[][] grid = new int[H][W];
        int[] res = new int[1];

        Arrays.sort(dots, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[2] - o1[2];
            }
        });

        for (int i = 0; i < dots.length; i++) {
            int x = dots[i][0];
            int y = dots[i][1];
            int darkness = dots[i][2];
            if (darkness <= grid[x][y]) {
                continue;
            }
            dfs(x, y, darkness, grid, res);
        }
        return res[0];
    }

    private void dfs(int x, int y, int darkness, int[][] grid, int[] res) {
        // need to update
        if (x < grid.length && x >= 0 && y < grid[0].length && y >= 0 && darkness > grid[x][y]) {
            // vertical
            for (int i = 0; i < grid.length; i++) {
                int newDarkness = darkness - Math.abs(i - x);
                if (newDarkness > grid[i][y]) {
                    res[0] += newDarkness - grid[i][y];
                    grid[i][y] = newDarkness;
                }
            }
            // horizontal
            for (int i = 0; i < grid[0].length; i++) {
                int newDarkness = darkness - Math.abs(i - y);
                if (newDarkness > grid[x][i]) {
                    res[0] += newDarkness - grid[x][i];
                    grid[x][i] = newDarkness;
                }
            }
        } else {
            return;
        }
        dfs(x - 1, y - 1, darkness - 2, grid, res);
        dfs(x - 1, y + 1, darkness - 2, grid, res);
        dfs(x + 1, y - 1, darkness - 2, grid, res);
        dfs(x + 1, y + 1, darkness - 2, grid, res);
    }

    public  int IndeedOA1822(int H, int W, int[][]dots) {
        int[][] grid = new int[H][W];
        int[] res = new int[1];

        Arrays.sort(dots, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[2] - o1[2];
            }
        });

        for (int i = 0; i < dots.length; i++) {
            int x = dots[i][0];
            int y = dots[i][1];
            int darkness = dots[i][2];
            if (darkness <= grid[x][y]) {
                continue;
            }
            dfs2(x, y, darkness, grid, res);
        }
        return res[0];
    }

    private  void dfs2(int x, int y, int darkness, int[][]grid, int[] res) {
        // need to update
        if (x < grid.length && x >= 0 && y < grid[0].length && y >= 0 && darkness > grid[x][y]) {
            // vertical
            for (int i = x; i < grid.length; i++) {
                int newDarkness = darkness - Math.abs(i - x);
                if (newDarkness > grid[i][y]) {
                    res[0] += newDarkness - grid[i][y];
                    grid[i][y] = newDarkness;
                } else {
                    break;
                }
            }
            for (int i = x ; i >= 0; i--) {
                int newDarkness = darkness - Math.abs(i - x);
                if (newDarkness >= grid[i][y]) {
                    res[0] += newDarkness - grid[i][y];
                    grid[i][y] = newDarkness;
                } else {
                    break;
                }
            }
            // horizontal
            for (int i = y; i < grid[0].length; i++) {
                int newDarkness = darkness - Math.abs(i - y);
                if (newDarkness > grid[x][i]) {
                    res[0] += newDarkness - grid[x][i];
                    grid[x][i] = newDarkness;
                } else {
                    break;
                }
            }

            for (int i = y; i >= 0; i--) {
                int newDarkness = darkness - Math.abs(i - y);
                if (newDarkness >= grid[x][i]) {
                    res[0] += newDarkness - grid[x][i];
                    grid[x][i] = newDarkness;
                } else {
                    break;
                }
            }
        } else {
            return;
        }
        dfs2(x - 1, y - 1, darkness - 2, grid, res );
        dfs2(x - 1, y + 1, darkness - 2, grid, res );
        dfs2(x + 1, y - 1, darkness - 2, grid, res );
        dfs2(x + 1, y + 1, darkness - 2, grid, res );
    }


    public static int IndeedOA1821(int H, int W, int[][] dots) {
        int[][] grid = new int[H][W];
        int[] result = new int[1];

        // 按dots中的darkness降序排序，当当前dot的darkness小于起始位置的darkness时，则skip
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o2[2] - o1[2];
            }
        });

        for (int[] dot: dots) {
            heap.add(dot);
        }

        while (!heap.isEmpty()) {
            int[] dot = heap.poll();
            int x = dot[0];
            int y = dot[1];
            int darkness = dot[2];

            if (grid[x][y] >= darkness) {
                continue;
            }

            dfs21(grid, x, y, darkness, result);
        }

		/*
		for (int[] g: grid) {
			for (int j: g) {
				System.out.print(j + ", ");
			}
			System.out.println();
		}
		*/
        return result[0];
    }

    private static void dfs21(int[][] grid, int x, int y, int darkness, int[] result) {
        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && darkness > grid[x][y]) {

            for (int i = 0; i < grid.length; i++) {
                if (darkness - Math.abs(i - x) > 0) {
                    int cur = darkness - Math.abs(i - x);
                    if (cur > grid[i][y]) {
                        result[0] += cur - grid[i][y];
                        grid[i][y] = cur;
                    }
                }
            }

            for (int j = 0; j < grid[0].length; j++) {
                if (darkness - Math.abs(j - y) > 0) {
                    int cur = darkness - Math.abs(j - y);
                    if (cur > grid[x][j]) {
                        result[0] += cur - grid[x][j];
                        grid[x][j] = cur;
                    }
                }
            }
        } else {
            return;
        }

        dfs21(grid, x + 1, y + 1, darkness - 2, result);
        dfs21(grid, x - 1, y - 1, darkness - 2, result);
        dfs21(grid, x + 1, y - 1, darkness - 2, result);
        dfs21(grid, x - 1, y + 1, darkness - 2, result);
    }
    public static int IndeedOA183(int H, int W, int[][] dots) {
        int[][] grid = new int[H][W];
        int[] result = new int[1];

        // 按dots中的darkness降序排序，当当前dot的darkness小于起始位置的darkness时，则skip
        Arrays.sort(dots, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[2] - o1[2];
            }
        });

        for (int i = 0; i < dots.length; i++) {
            int x = dots[i][0];
            int y = dots[i][1];
            int darkness = dots[i][2];
            if (darkness <= grid[x][y]) {
                continue;
            }
            bfs(grid, x, y, darkness, result);
        }

        return result[0];
    }

    private static void bfs(int[][] grid, int x, int y, int darkness, int[] result) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        queue.offer(new int[] {x, y, darkness});
        while (!queue.isEmpty()) {
            int[] dot = queue.poll();
            int i = dot[0];
            int j = dot[1];
            int val = dot[2];

            result[0] += val - grid[i][j];
            grid[i][j] = val;

            for (int[] dirs: direction) {
                int nextI = i + dirs[0];
                int nextJ = j + dirs[1];
                int nextVal = val - 1;
                if (nextI >= 0 && nextI < grid.length && nextJ >= 0 && nextJ < grid[0].length && nextVal > grid[nextI][nextJ]) {
                    queue.offer(new int[]{nextI, nextJ, nextVal});
                }
            }
        }
    }
}
