package java;

public class Decompress1 {
    public String decompress(String input) {
        // Write your solution here
        if (input.length() == 0) {
            return input;
        }
        // sum up numbers and create new string, two pointers filled from left to right
        char[] arr = input.toCharArray();
        int length = arr.length + counter(arr);
        char[] res = new char[length];
        int slow = res.length - 1;
        int fast = arr.length - 1;
        while (fast >= 0) {
            if (arr[fast] <= '9') {
                int count = arr[fast] -'1';
                fast--;
                while (count > 0) {
                    res[slow--] = arr[fast];
                    count--;
                }
            } else {
                res[slow--] = arr[fast--];
            }
        }
        return new String(res);
    }
    private int counter(char[] arr) {
        int count = 0;
        for (char c : arr) {
            if (c <= '9') {
                count = count + c - '2';
            }
        }
        return count;
    }
}
