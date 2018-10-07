class Solution:
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: List[str]
        """
        def findWord(stri,wordDict,memo):
            res = []
            results=[]
            if stri in memo: return memo[stri] 
            if not stri: return []
            for i in range(1,len(stri)+1):
                if stri in memo: return memo[stri]
                if stri[:i] in wordDict :
                    if i < len(stri):
                        results = findWord(stri[i:],wordDict,memo)
                        for item in results:
                            res.append(stri[:i]+' '+ item)
                    else:
                        res.append(stri[:i])
            memo[stri] = res           
            return res
        return findWord(s,wordDict,{})
a = Solution()
print(a.wordBreak('catsanddog',["cat","cats","and","sand","dog"]))