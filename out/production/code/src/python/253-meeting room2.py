# Definition for an interval.
# class Interval:
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e
class Solution:
    def minMeetingRooms(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: int
        """
        lis = []
        for x in intervals:
            lis.append((x.start,0.01))
            lis.append((x.end,0))
        lis.sort(key=lambda tup:tup[0]+tup[1])
        print(lis)
        count, max_count = 0, 0
        for y in lis:
            if y[1]:
                count += 1
            else:
                count -= 1
            max_count = max(count,max_count)
        return max_count