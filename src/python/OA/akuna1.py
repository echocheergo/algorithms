def process(line):
    #what is unpexted data
    #for each line in file output once?
    head = int(line[:6], 16)
    if getSum(head) == int(line[6:],16):
        return 'VALID'
    else:
        return 'INVALID'

def getSum(n):
    r = 0
    while n:
        r, n = r + n%10, n//10
    return r
print(process('C0FFEE1C'))