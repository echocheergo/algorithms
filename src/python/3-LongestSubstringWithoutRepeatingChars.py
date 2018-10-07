class Solution(object):
    def lengthOfLongestSubstring(self, s):
        '''
        use dict for used chars and update when new comes
        '''
        i = res = 0     
        used = {}
        for j in range(len(s)):
            if s[j] in used and i <= used[s[j]]:
                i = used[s[j]] + 1
            else:
                res = max(res, j - i + 1)
            used[s[j]] = j
        return res