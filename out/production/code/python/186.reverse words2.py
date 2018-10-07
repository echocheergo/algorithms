class Solution(object):
    def reverseWords(self, s):
        """
        :type s: a list of 1 length strings (List[str])
        :rtype: nothing
        """
        s.reverse()

        index = 0
        for i in range(len(s)):
            if s[i] == " ":
                s[index: i] = reversed(s[index: i])
                index = i + 1

        s[index: ] = reversed(s[index: ])

a = Solution()
print(a.reverseWords(['the',' ','sky',' ','is']))