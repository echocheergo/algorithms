# This is the interface that allows for creating nested lists.
# You should not implement it, or speculate about its implementation
# """
#class NestedInteger(object):
#    def isInteger(self):
#        """
#        @return True if this NestedInteger holds a single integer, rather than a nested list.
#        :rtype bool
#        """
#
#    def getInteger(self):
#        """
#        @return the single integer that this NestedInteger holds, if it holds a single integer
#        Return None if this NestedInteger holds a nested list
#        :rtype int
#        """
#
#    def getList(self):
#        """
#        @return the nested list that this NestedInteger holds, if it holds a nested list
#        Return None if this NestedInteger holds a single integer
#        :rtype List[NestedInteger]
#        """

class NestedIterator(object):

    def __init__(self, nestedList):
        """
        yield generator for each ele
        """
        def get(nestedList):
            for row in nestedList:
                if row.isInteger():
                    yield row
                else:
                    for i in get(row.getList()):
                        yield i
        self.itr = get(nestedList)
        self.cur = next(self.itr, None)

    def next(self):
        tmp = self.cur
        self.cur = next(self.itr, None)
        return tmp
        

    def hasNext(self):
        return self.cur != None


# Your NestedIterator object will be instantiated and called as such:
# i, v = NestedIterator(nestedList), []
# while i.hasNext(): v.append(i.next())