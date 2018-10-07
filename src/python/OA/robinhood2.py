def wordWrap(input, k):
    if len(input) <= k:
        print(input)
    i, j = 0, k-1
    res = []
    while j < len(input) and i < j:
        if input[j+1] != ' ' and j < len(input) - 1:
            j -= 1
            
        else:
            res.append(input[i:j+1])
            i = j + 2
            j = i + k - 1
    if i == j:
        print('')
    else:
        if i < len(input) and j >= len(input):
            res.append(input[i:])
        for i in res:
            print(i)

wordWrap('', 6)