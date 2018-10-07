import collections
class Solution:
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: List[str]
        """
        res= []
        def findWord(stri,wordDict,path,res):
            path2 = collections.defaultdict(str)
            for i in range(1,len(stri)+1):
                if stri[:i] in wordDict:
                    if i < len(stri):
                        path2[stri[:i]] = path+stri[:i] +' '
                        findWord(stri[i:],wordDict,path2[stri[:i]],res)
                    else:
                        path2[stri[:i]] = path+stri[:i]
                        res.append(path2[stri[:i]])
        findWord(s,wordDict,'',res)
        return res
a = Solution()
a.wordBreak('ab',['a','b'])

class Solution:
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: List[str]
        """
        def findWord(stri,wordDict,memo):
            res = []
            if stri in memo: return memo
            if not stri: return []
            for i in range(1,len(stri)+1):
                if stri in memo: return memo[str]
                if stri[:i] in wordDict :
                    if i < len(stri):
                        results = findWord(stri[i:],wordDict,memo)
                        for item in results:
                            item = stri[:i]+' '+ item
                            res.append(item)
                    else:
                        res.append(stri[:i])
            memo[stri] = res           
            return res
        return findWord(s,wordDict,{})

##3 
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
