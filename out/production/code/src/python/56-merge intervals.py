# Definition for an interval.
# class Interval:
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e

class Solution:
    def merge(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: List[Interval]
        """
        # assume the intervals are sorted by the first element in ascending fashion
        intervals.sort(key=lambda x: x.start)
        ind, res = 0, []
        if len(intervals) < 2:
            return intervals
        while ind + 1 < len(intervals):
            a, b = intervals[ind], intervals[ind+1]
            if a.end >= b.start:
                res.append(Interval(a.start, max(a.end, b.end)))
                while ind + 2 < len(intervals) and res[-1].end >= intervals[ind+2].start:
                    res[-1].end = max(res[-1].end, intervals[ind+2].end)
                    ind += 1
                ind += 1
            else:
                res.append(a)
            ind += 1
        if res[-1].end < intervals[-1].start:
            res.append(intervals[-1])
            
        
        return res
            
            
        