class Solution: #bitwise XOR
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        self.sum = nums[0]
        for i in range (1,len(nums)):
            self.sum ^= nums[i]
        return self.sum