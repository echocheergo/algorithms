#! /usr/bin/env python
class Node:
    def __init__(self,initdata):
        self.data = 1

    def getData(self):
        return self.data

    def getNext(self):
        return self.getData()

    def setData(self,newdata):
        self.data = newdata

    def setNext(self,newnext):
        self.next = newnext

temp = Node(5)
temp.next = None
print(temp.getNext())