class Solution:
    # @return a string
    def longestCommonPrefix(self, strs):
        if not strs:
            return ""
            
        for i, letter_group in enumerate(zip(*strs)):
            if len(set(letter_group)) > 1:
                return strs[0][:i]
    
        return min(strs) # equal to else in for loop, run when loop breaks or ends

a = Solution()
b = ["abcde","abd","abcd"]
c = zip(*b)
print(c)
print(a.longestCommonPrefix(b))