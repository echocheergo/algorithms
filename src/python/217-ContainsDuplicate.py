#!/usr/bin/env python
class Solution:
    def containsDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        memory = set()
        for i, x in enumerate(nums):
            if x in memory:
                return True
            memory.add(x)
        return False