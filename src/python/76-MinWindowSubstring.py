import collections
class Solution:
    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        tar = collections.Counter(t)
        st, e, counter = 0, 0, 0
        i = 0
        for j, ch in enumerate(s):
            if (tar[ch] > 0):
                counter += 1
            tar[ch] -= 1
            if counter == len(t):
                # adjust i
                while i <= j and tar[s[i]] < 0:
                    tar[s[i]] += 1
                    i += 1
                # update s e, mindful about first time updating 
                if e == 0 or j - i < e - st:
                    st, e = i, j + 1
                # move i and adjust counter
                counter -= 1
                tar[s[i]] += 1
                i += 1
        return s[st : e]
s = 'ABCBD'
t = 'ABD'
res = Solution()
print(res.minWindow(s, t))
