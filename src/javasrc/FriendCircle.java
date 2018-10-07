package javasrc;

public class FriendCircle {
    // all students are disjoint set, friend circle is connected set, union find
    // path compression by halving
    // union by rank
    // keep count-- independent root
    public int findCircleNum(int[][] M) {
        int n = M.length;
        UnionFind uf = new UnionFind(n);
        // for each student, union find people on the right if they are connected
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.count();
    }
    class UnionFind {
        private int count;
        private int[] parent, rank;

        UnionFind(int n) {
            count = n;
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];// path compression by halving
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            // same set, return
            if (rootP == rootQ) {
                return;
            }
            // union by rank
            if (rank[rootP] > rank[rootQ]) {
                parent[rootQ] = rootP;
            } else {
                parent[rootP] = rootQ;
                // same rank, lift root rank by 1
                if (rank[rootP] == rank[rootQ]) {
                    rank[rootQ]++;
                }
            }
            count--;
        }

        public int count() {
            return count;
        }
    }
}
