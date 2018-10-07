import itertools
class Solution(object):
    def convert1(self,s, numRows):
        if numRows<2 or len(s)<numRows: return s
        self.n = numRows-1
        self.step = self.n*2
        self.res = s[::self.step]
        for i in range(1,self.n):
            for v,w in itertools.zip_longest(s[i::self.step],s[self.step-i::self.step],fillvalue=''):
                self.res += v+w
        return self.res + s[self.n::self.step]

a = Solution()
print(a.convert1('ABCDEFGH',3))