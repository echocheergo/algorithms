package javasrc;

import java.util.Arrays;
// idea: sort coins first, DFS use larger coin as much as possible
//
public class CoinChange {
    int minCount = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        count(amount, coins.length - 1, coins, 0);
        return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }

    void count(int amount, int index, int[] coins, int count) {
        // base case
        if(amount % coins[index] == 0) {
            int newCount = count + amount / coins[index];
            if(newCount < minCount)
                minCount = newCount;
            //return;  // Not sure why return here will slow down in OJ. It's better in my local test however.
        }

        if(index == 0)
            return;
        // DFS test all cases that use current coin
        // check if use next coin will definitely exceed curr minCount
        for (int i = amount / coins[index]; i >= 0; i--) {
            int newAmount = amount - i * coins[index];
            int newCount = count + i;

            int nextCoin = coins[index-1];
            if(newCount + (newAmount + nextCoin -1) / nextCoin >= minCount)
                break;

            count(newAmount, index - 1, coins, newCount);
        }
    }
}
