def wordWrap(input, k):
    if len(input) < k:
        return [input]
    words = input.split()[::-1]
    window, res = "", []
    while words:
        if len(window + " " + words[0]) <= k:
            window += " " + words.pop(-1)[0]
        else:
            res.append(window)
            window = []
    return res

print(wordWrap("aaa vvv ddd sad dggefe ew d ewqewqw fsaffsdsdsfdsff dsasa", 5))
