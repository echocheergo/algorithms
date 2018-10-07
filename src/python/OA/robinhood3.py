import functools
def parse(filePath):
    res = []
    with open(filePath) as f:
        for line in f:
            res.append(line)
    return res
def checkReturn(file1, file2):
    f1 = parse(file1)
    f2 = parse(file2)
    book = {}
    for i in f1[1:]:
        h = i.split(' ')
        book[h[1]] = int(h[3].lstrip('$')) * int(h[0])
    
    for j in f2[1:]:
        t = j.split(' ')
        if t[0] == 'bought':
            book[t[2]] -= int(t[4].lstrip('$')) * int(t[1])
        else:
            book[t[2]] += int(t[4].lstrip('$')) * int(t[1])
    print('Total ${}'.format(sum(book.values())))
    for entry in sorted(book.items(), key=lambda x:-x[1]):
          print('{} ${}'.format(entry[0], entry[1]))

checkReturn('/Users/echo/Dropbox/code/src/python/OA/test1.txt', '/Users/echo/Dropbox/code/src/python/OA/test2.txt')