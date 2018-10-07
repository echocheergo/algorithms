package javasrc;

public class MergeStones {
    // modify to same as cutting wood or record another 2D array for subSum
    public int minCost(int[] stones) {
        int n = stones.length;
        int[] cut = new int[n + 1];
        cut[0] = 0;
        for (int i = 0; i < n; i++) {
            cut[i + 1] = stones[i] + cut[i];
        }
        // cost array
        int[][] cost = new int[n + 1][n + 1];
        for (int i = n ; i >= 0; i--) {
            for (int j = i + 1; j < n + 1; j++) {
                cost[i][j] = j == i + 1 ? 0 : (cut[j] - cut[i] + cost[i][i + 1] + cost[i + 1][j]);
                if (j > i + 2) {
                    for (int k = i + 2; k < j; k++) {
                        cost[i][j] = Math.min(cost[i][j], cut[j] - cut[i] + cost[i][k] + cost[k][j]);
                    }
                }
            }
        }
        return cost[0][n];
    }
}
