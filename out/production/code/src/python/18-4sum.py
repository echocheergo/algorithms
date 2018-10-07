class Solution:
    def fourSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        nums.sort()
        results = []
        self.findSum(nums,target,4,[],results)
        return results
    
    def findSum(self,nums,target,N,result,results):
        if len(nums) < N or N < 2 or target < nums[0]*N or target > nums[-1]*N:
            return 
        if N == 2:
            f,e = 0, len(nums)-1
            while f < e:
                s = nums[f] + nums[e]
                if s == target:
                    results.append(result + [nums[f]] + [nums[e]])
                    f += 1
                    while f< e and nums[f] == nums[f-1]:
                        f += 1
                elif s < target:
                    f += 1
                else:
                    e -= 1
        else:
            for i in range(len(nums)-N+1):
                if i == 0 or (i > 0 and nums[i-1] != nums[i]):
                    self.findSum(nums[i+1:],target -nums[i], N-1, result + [nums[i]], results)

        