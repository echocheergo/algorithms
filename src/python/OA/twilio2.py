def missingWords(tep, sub):
    res = []
    teps = tep.split()
    subs = sub.split()
    i = j = 0
    while i < len(teps) and j < len(subs):
        if teps[i] != subs[j]:
            i += 1
        else:
            res.append(teps[i])
            i += 1
            j += 1
    return res
s = 'am Echo'
t = 'Hi I am awesome Echo bye'
print(missingWords(t,s))