class Solution(object):
    def numDecodings(self, s):
        """
        iterative DP, ways_i = ways_i-1 if i legit + ways_i-2 if i+i-1 legit
        """
        w0, w1, prev = 0, int(s>''), ''
        for cur in s:
            w0, w1, prev = w1, (cur>'0')*w1 + (9<int(prev+cur)<27)*w0, cur
        return w1