class Solution:
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        self.dic = {1:1, 2:2}
        for i in range(3,n+1):
            self.dic[i] = self.dic[i-1] + self.dic[i-2]
        return self.dic[n]
a = Solution()
print(a.climbStairs(50))