package javasrc;


public class CutWood {
    public int minCost(int[] cuts, int length) {
        //assumption L >= 2
        // obtain cut-length map
        int n = cuts.length;
        int[] cut = new int[n + 2];
        cut[0] = 0;
        cut[n + 1] = length;
        for (int i = 0; i < n; i++) {
            cut[i + 1] = cuts[i];
        }
        // cost array
        int[][] cost = new int[n + 1][n + 2];
        for (int i = n ; i >= 0; i--) {
            for (int j = i + 1; j < n + 2; j++) {
                cost[i][j] = j == i + 1 ? 0 : (cut[j] - cut[i] + cost[i][i + 1] + cost[i + 1][j]);
                if (j > i + 2) {
                    for (int k = i + 2; k < j; k++) {
                        cost[i][j] = Math.min(cost[i][j], cut[j] - cut[i] + cost[i][k] + cost[k][j]);
                    }
                }
            }
        }
        return cost[0][n + 1];
    }
}
