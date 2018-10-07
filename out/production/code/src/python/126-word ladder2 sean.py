class Solution:
    def findLadders(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: List[List[str]]
        """
        def ifAdjacent(w1, w2):
            count = 0
            for k in range(len(w1)):
                if w1[k] != w2[k]:
                    count += 1
                if count > 1:
                    break
            return count == 1
        
        def findHelper(graph, curWord, endWord, path, res):
            path.append(curWord)
            if curWord == endWord: # found a path
                if not res or len(path) == len(res[0]):
                    res.append(path)
                elif len(path) < len(res[0]):
                    res = [path]
                return res
            elif res and len(path) >= len(res[0]): # already longer 
                return res
            else: # keep DFS
                for nextWord in graph[curWord]:
                    if nextWord not in path:
                        res = findHelper(graph, nextWord, endWord, path[:], res)
                return res
                
        
        # Build a graph
        graph = collections.defaultdict(set)
        allWords = [beginWord] + wordList
        for i in range(len(allWords)):
            for j in range(i + 1, len(allWords)):
                if ifAdjacent(allWords[i], allWords[j]):
                    graph[allWords[i]].add(allWords[j])
                    graph[allWords[j]].add(allWords[i])
        print('graph built')
        # Start with beginWord, DFS along the graph
        return findHelper(graph, beginWord, endWord, [], [])
        
                        