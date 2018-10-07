package javasrc;

public class PaintHouse256 {
    public int minCost(int[][] costs) {
        // depends on previous status, current can have three sets of status
        // three DP, get min
        if (costs.length == 0) {
            return 0;
        }
        int n = costs.length;
        int pre0 = costs[0][0];
        int pre1 = costs[0][1];
        int pre2 = costs[0][2];
        for (int i = 1; i < n; i++) {
            int cur0 = Math.min(pre1, pre2) + costs[i][0];
            int cur1 = Math.min(pre0, pre2) + costs[i][1];
            int cur2 = Math.min(pre0, pre1) + costs[i][2];
            pre0 = cur0;
            pre1 = cur1;
            pre2 = cur2;
        }
        return Math.min(Math.min(pre0, pre1), pre2);
    }
}
