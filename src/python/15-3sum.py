import collections
class Solution:
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        pos, negative, res = [], [], set()
        nums.sort()
        for n in nums:
            if n > 0:
                pos.append(n)
            elif n < 0:
                negative.append(n)
        num = collections.Counter(nums)
        if pos and negative:
            for i in pos:
                for j in negative:
                    if -i-j in num:
                        if -i-j != i and -i-j != j:
                            res.add(tuple(sorted((i,j,-i-j))))
                        else:
                            if num[-i-j] > 1:
                                res.add(tuple(sorted((i,j,-i-j))))
        if 0 in num and num[0] > 2:
            res.add((0,0,0))
        return list(res)

