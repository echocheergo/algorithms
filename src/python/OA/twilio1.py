#Hosts and total number of requests
#http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=447185&extra=page%3D2%26filter%3Dlastpost%26orderby%3Dlastpost%26sortid%3D311%26sortid%3D311%26orderby%3Dlastpost
from collections import defaultdict
def parse(filePath):
    res = defaultdict(lambda :0)
    with open(filePath) as f:
        for line in f:
            res[line.split()[0]] += 1   
    with open('records_'+filePath, 'w+') as out:
        for entry in res.items():
            out.write('{} {}\n'.format(entry[0], entry[1]))
        return out
parse('test3.txt')