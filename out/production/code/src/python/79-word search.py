#! /usr/bin/env python
class Solution:
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        self.word = word
        self.isFound = False
        for row in range(len(board)):
            for col in range(len(board[0])):
                self.visited = []
                self.visitedSet = set()
                self.dfs(board,row,col,0)
                if self.isFound:
                    return True
            return False

    def dfs(self,board,row,col,i):
        if i == len(self.word):
            self.isFound = True
        if not self.isFound and row in range (0,len(board)) and col in range(0, len(board[0])) and board[row][col] == self.word[i] and (row,col) not in self.visitedSet:
            self.visited += (row,col)
            self.visitedSet.add((row,col))
            self.dfs(board,row+1,col,i+1)
            self.dfs(board,row-1,col,i+1)
            self.dfs(board,row,col+1,i+1)
            self.dfs(board,row,col-1,i+1)

            if not self.isFound:
                self.visitedSet.remove(self.visited.pop())


