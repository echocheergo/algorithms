#counter of city, sort by freq then alpha
#total dis
#for each accont: maintain distance as dict and global max
from collections import defaultdict
class StatisticsCal:
    userDict = defaultdict(int)
    cityCount = defaultdict(int)
    maxU = [0, '']
    maxC = 0
    totalD = 0
    
    def process(self, line):
        l = line.split(':')
        self.totalD += int(l[-1])
        self.userDict[l[0]] += int(l[3])
        if self.userDict[l[0]] > self.maxU[0]:
            self.maxU[0] = self.userDict[l[0]]
            self.maxU[1] = l[0]
        self.cityCount[l[1]] += 1
        self.cityCount[l[2]] += 1
        self.maxC = max(self.cityCount[l[1]], self.cityCount[l[2]], self.maxC)
        
        return '{}:{}:{}'.format(self.totalD, self.maxU[1], sorted(filter(lambda x:x[1] == self.maxC, self.cityCount.items()))[0][0])

res = StatisticsCal()
print(res.process('C0FFEE1C:NYC:CHI:714'))
print(res.process('0FF1CE18:NYC:SEATTLE:961'))
print(res.process('C0FFEE1C:NYC:LA:2448'))