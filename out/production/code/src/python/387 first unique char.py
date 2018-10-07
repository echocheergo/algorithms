import string
class Solution(object):
    def firstUniqChar(self, s):
        return min([s.find(c) for c in string.ascii_lowercase if s.count(c)==1] or [-1])
a = Solution()
print(a.firstUniqChar('teet'))