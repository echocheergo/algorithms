class Solution:
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        def findSeg(s,maxct,endind):
            ct,pool = 0, {}
                for i in range(len(s)):
                    if s[i] not in pool:
                        pool[s[i]] = i
                        ct += 1
                    else:
                        if ct > maxct:
                            maxct,endind = ct,i
                            findSeg(s[pool[s[i]] + 1:], maxct,endind)
                        else:
                            findSeg(s[pool[s[i]] + 1:], maxct, endind)
        maxct, endind = 0,0
        findSeg(s,maxct, endind)   
        print(endind)
        return s[endind-maxct:endind]

            
a= Solution()

a.lengthOfLongestSubstring('abcabcbb')