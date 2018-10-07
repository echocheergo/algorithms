import collections
class Solution:
    def topKFrequent(self, words, k):
        """
        :type words: List[str]
        :type k: int
        :rtype: List[str]
        """
        wd = collections.defaultdict(int)
        for w in words:
            wd[w] += 1
					
        res = wd.keys()
        re = sorted(res, key=lambda x:(-wd[x],x) )

        return re[:k]