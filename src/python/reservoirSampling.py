import random
def getK(n, k, input):
    i = 0
    res = [0] * k
    for i in range(k+1):
        res[i] = input[i]
    while (i < n):
        j = random.randint(0, i)
        if j <= k:
            res[j] = input[i]
        i += 1
    return res