class Solution:
    def ladderLength(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: int
        """
        if endWord not in wordList:
            return 0
        front, back, wordList = set([beginWord]), set([endWord]), set(wordList)
        wordList.discard(beginWord)
        path = 2
        while front:
            front = wordList & (set(word[:ind]+ch+word[ind+1:] for word in front for ind in range(len(beginWord)) for ch in string.ascii_lowercase))
            if front & back:
                return path
            path += 1
            if len(front) > len(back):
                front, back = back, front
            wordList -= front
            
        
        return 0
a = Solution()
print(a.ladderLength('hit','dog',[['hot'],['hog'],['hat'],['dot'],['dog']))