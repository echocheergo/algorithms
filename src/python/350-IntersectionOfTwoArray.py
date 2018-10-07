import collections
class Solution(object):
    
    def intersect(self, nums1, nums2):
        # two pointers
        # n1 = sorted(nums1)
        # n2 = sorted(nums2)
        # p1, p2 = 0, 0
        # res = []
        # while True:
        #     try:
        #         if (n1[p1] < n2[p2]):
        #             p1 += 1
        #         elif (n1[p1] > n2[p2]):
        #             p2 += 1
        #         else:
        #             res.append(n1[p1])
        #             p1 += 1
        #             p2 += 1
        #     except IndexError:
        #         break
        # return res
        # counter as freq map of smaller
        if len(nums1) < len(nums2):
            map = collections.Counter(nums1)
            res = self.getInter(map, nums2)
        else:
            map = collections.Counter(nums2)
            res = self.getInter( map, nums1)
        return res
    def getInter(self, map, nums):
        res = []
        for i in nums:
            if map[i] > 0:
                map[i] -= 1
                res.append(i)
        return res

obj = Solution()
res = obj.intersect([1,2,3,4,3,2,1], [2,3,4,1,2,4])
print(res)
