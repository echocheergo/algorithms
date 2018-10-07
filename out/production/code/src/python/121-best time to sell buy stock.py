class Solution:
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        self.maxprofit, self.minPrice = 0, float('inf') # as unbounded upper limit, set infinite to find the smallest
        for price in prices:
            self.minPrice = min(self.minPrice, price)
            self.profit = price - self.minPrice
            self.maxprofit = max(self.maxprofit, self.profit)
        return self.maxprofit