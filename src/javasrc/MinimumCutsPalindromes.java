package javasrc;

public class MinimumCutsPalindromes {
    public int minCuts(String input) {
        // Write your solution here
        // preprocess to get isP for all substring
        // DP to get min cuts, left part to look up , right part need to be isP, get min (need to refer all previous)
        if (input.length() <= 1) {
            return 0;
        }
        int n = input.length();
        char[] arr = input.toCharArray();
        int[] minCut = new int[n + 1];

        // preproces, isP[start][end] represent if substring start - 1][end -1] is P
        // a string is P: single char; two char and same; same char at out + inner isP opp direction
        boolean [][] isP = new boolean[n + 1][n + 1];
        for (int e = 1; e < n + 1; e++) {
            minCut[e] = e - 1;
            for (int s = e; s > 0; s--) {
                if (arr[s - 1] == arr[e - 1]) {
                    isP[s][e] = e - s < 2 || isP[s + 1][e - 1];
                }
                if (isP[s][e]) {
                    minCut[e] = Math.min(minCut[e], minCut[s - 1] + 1);
                }
            }
        }
        return minCut[n];

    }
}
