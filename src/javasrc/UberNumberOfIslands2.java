package javasrc;

import java.util.ArrayList;
import java.util.List;

public class UberNumberOfIslands2 {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        // build parent array for the whole matrix, only init with ind for those in positions
        // for each 1, init parent, test if union is needed for adjacent
        // add the # of disjoint set
        // O((M + N) lg*N) + mn initialization; M operation N objects
        // if mn large, can use hashmap
        UnionFind isLands = new UnionFind(m, n);
        List<Integer> res = new ArrayList<>();
        int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        // iterate, make set, find adjacent and union
        for (int[] pos : positions) {
            int x = pos[0];
            int y = pos[1];
            int p = isLands.add(x, y);
            // iterate 4 adjacent
            for (int[] dir : dirs) {
                int q = isLands.getId(x + dir[0], y + dir[1]);
                if (q > 0 && !isLands.find(p, q)) {
                    isLands.unite(p, q);
                }
            }
            res.add(isLands.size());
        }
        return res;
    }
}
class UnionFind {
    private int[] id; // parent in compressed 2D format, if 0 then default 0, if 1 then record its compressed index as init,
    private int[] rank;
    private int m, n, count;

    public UnionFind(int m, int n) {
        this.m = m;
        this.n = n;
        this.id = new int[m * n + 1];
        this.rank = new int[m * n + 1];
        this.count = 0;
    }

    public int size() {
        return this.count;
    }

    public int index(int x, int y) {
        return x * n + y + 1;
    }

    public int getId(int x, int y) {
        if (x >= 0 && x < m && y >= 0 && y < n) {
            return id[index(x, y)];
        }
        return 0;
    }

    public int add(int x, int y) {
        int i = index(x, y);
        id[i] = i;
        rank[i] = 1;
        count++;
        return i;
    }

    public boolean find(int p, int q) {
        return root(p) == root(q);
    }

    public void unite(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (rank[i] > rank[j]) {
            id[j] = i;
            rank[i] += rank[j];
        } else {
            id[i] = j;
            rank[j] += rank[i];
        }
        count--;
    }

    public int root(int x) {
        if (id[x] == x) {
            return x;
        }
        x = root(id[x]);
        return x;
    }

}
