class Solution:
# @param A, a list of integers
# @return an integer
    def maxProduct(self, A):
        MinTemp = A[0]
        MaxTemp = A[0]
        Max = A[0]
        for i in range(1, len(A)):
            MinTemp, MaxTemp = min(A[i], A[i] * MaxTemp, A[i] * MinTemp), max(A[i], A[i] * MaxTemp, A[i] * MinTemp)
            Max = max(Max, MaxTemp)
        return Max
a = Solution()
print(a.maxProduct([2,-3,4,-2]))