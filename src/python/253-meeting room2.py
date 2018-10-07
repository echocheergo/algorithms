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
        starts = sorted([i.start for i in intervals])
        ends = sorted([i.end for i in intervals])
        
        rooms = empty = 0
        s = e = 0
        while s < len(intervals):
            if starts[s] < ends[e]:
                if empty < 1:
                    rooms += 1
                else:
                    empty -= 1
                s += 1
            else:
                empty += 1
                e += 1
        return rooms