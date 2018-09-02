package java;

public class buyAndSellStock121 {
    public int maxProfit(int[] prices) {
        int max = 0;
        int globalStart = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                if (prices[i - 1] - prices[globalStart]  > max) {
                    max = prices[i - 1] - prices[globalStart];
                }
                if (prices[globalStart] > prices[i]) {
                    globalStart = i;
                }
            }
            System.out.println("globalStart: " + prices[globalStart]);
        }
        max = Math.max(max, prices[prices.length - 1] - prices[globalStart]);
        return max;
    }
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int max = 0;
        int s = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                if (i < 2 || prices[i - 1] < prices[i - 2]) {
                    s = i;
                } else {
                    max += (prices[i - 1] - prices[s]);
                    s = i;
                }
            }
            System.out.println(s);
        }
        if (prices[prices.length - 1] >= prices[prices.length - 2]) {
            max += prices[prices.length - 1] - prices[s];
        }
        return max;
    }
}
