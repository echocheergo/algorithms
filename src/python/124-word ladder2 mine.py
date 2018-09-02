class Solution:
    def findLadders(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: List[List[str]]
        """
        self.n = len(beginWord)
        graph = self.buildGraph(wordList)
        first_layer, total = [], []
        for word in wordList:
            if self.findDiff(beginWord, word) == 1:
                first_layer.append(word)
        if not first_layer or not graph:
            return []
        self.path = [[beginWord] + [r] for r in first_layer]
        for word in first_layer:
            total += self.helpfind(graph,word,endWord)
        return total
        
                
        
    def findDiff(self,word, word2):
        diff = 0
        for i in range(self.n):
            if word[i] != word2[i]:
                diff += 1
            if diff > 1:
                    break 
        return diff
    
    def helpfind(self,graph,word,endWord):
        """
        graph: dict of (str, list(str))
        word: str
        endWord: str
        rtype: list(list(str)), pth
        keep visiting nodes along graph connections 
        and check if endnode can be found in nodes that are connected with last node, 
        record each node visited.
        Stop when endnode is found or reach the end of graph connection.
        reject all paths that don't reach endnode and return those that have reach endnode.
        
        """
        if graph[word]:    
            n = graph[word]
            if endWord in n:
                    return self.path[].append([endWord])
            for i in n:
                self.path[res].append([i])
                self.helpfind(graph,i,endWord)
        return []
                
        
    def buildGraph(self,wordList,endWord):
        endNotIso = False
        for word in wordList:
            for word2 in wordList:
                if self.findDiff(word, word2) == 1: 
                    graph[word].append(word2)
            if word != endWord and endWord in graph[word]:
                endNotIso = True
        if endNotIso:
            return graph
        return None
    
            