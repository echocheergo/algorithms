#use a dict for each type of char
#value is a list [frequency, start, end]
#sort dict.values as a tuple (frequency, end - start + 1)

def getSubarr (input):
    nummap = {}
    #enumerate and get frequency together with start and end index
    for i, num in enumerate(input):
        if num in nummap:
            nummap[num][0] += 1
            nummap[num][2] = i
        else:
            nummap[num] = [1, i, i]
    print(nummap)
    return sorted([(-i[0], i[2]-i[1]+1) for i in nummap.values()])[0][1]


print(getSubarr([1,2,2,3,1]))