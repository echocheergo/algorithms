class Solution:
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        self.stack = []
        dic = {')':'(', ']':'[','}':'{'}
        for cha in s:
            if cha in dic.values():
                self.stack.append(cha)
            elif cha in dic.keys():
                if self.stack == [] or dic[cha] != self.stack.pop():
                    return False
            else:
                return False
        return self.stack == []