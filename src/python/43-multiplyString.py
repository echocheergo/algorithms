class Solution():
    def multiply(self, num1, num2):
      if num1[0] == '0' or num2[0] == '0':
        return '0'
      res = [0] * (len(num1) + len(num2) + 1)
      for i, nu1 in enumerate(num1[::-1]):
        for j, nu2 in enumerate(num2[::-1]):
          tmp = int(nu1) * int(nu2)
          res[i+j] += tmp % 10
          res[i+j+1] += tmp // 10
      for k in range(len(res) - 1):
        res[k+1] += res[k] // 10
        res[k] = res[k] % 10
      if len(res) == 1:
        return str(res)
      return ''.join([str(x) for x in res[::-1]]).lstrip('0')
        
          
s = Solution()
print(s.multiply("0", "0"))