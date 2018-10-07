#!/usr/bin/env python
# alternatively use a dictionary to map value
# index remember to update in each case


class Solution:

    def __init__(self):
        pass
        
    def value(self, c):
        if (c == 'I'):
            return 1
        if (c == 'V'):
            return 5
        if (c == 'X'):
            return 10
        if (c == 'L'):
            return 50
        if (c == 'C'):
            return 100
        if (c == 'D'):
            return 500
        if (c == 'M'):
            return 1000
        return -1

    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        res = 0
        i = 0
        while (i < len(s)):
            v1 = self.value(s[i])
            if (i+1 < len(s)):
                v2 = self.value(s[i+1])
                if (v1 >= v2):
                    res = res + v1
                    i = i + 1
                else:
                    res = res + v2 - v1
                    i = i + 2
            else:
                res = res + v1
                i += 1
        return res

a = Solution()
print(a.romanToInt('DCXXI'))

