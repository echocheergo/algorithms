package javasrc;
import java.util.ArrayDeque;
import java.util.Deque;

public class UberBasicCalculator1 {
    public int calculate(String s) {
        // no need a stack: recursive to call and return when hit ')' so need modify input
        // since recursive, need to know where is processed in the whole s, can use a parameter to pass or use global variable
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] position = {0};
        s = "(" + s + ")";
        int res = 0;
        return eval(s, position);
    }

    private int eval(String s, int[] p) {
        int num = 0;
        int sign = 1; // 1 for + -1 for -
        int i = p[0];
        int val = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            switch (c) {
                case '+':
                    val += sign * num;
                    num = 0;
                    sign = 1;
                    i++;
                    break;
                case '-':
                    val += sign * num;
                    num = 0;
                    sign = -1;
                    i++;
                    break;
                case '(':
                    p[0] = i + 1;
                    val += sign * eval(s, p);
                    i = p[0] ;
                    break;
                case ')':
                    p[0] = i + 1;
                    val += sign * num;
                    return val;
                case ' ':
                    i++;
                    break;
                default:
                    num = num * 10 + c - '0';
                    i++;

            }
        }
        return val;
    }
    // iterative
    // iterative: if use a stack: only use for () to store stuff outside
    // default: start, start within (), after (); reset: when finish operation
    public int calculate2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int num = 0;
        int res = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                sign = 1;
                num = 0;
                res = 0;
            } else if (c == ')') {
                res += sign * num;
                sign = 1;
                num = 0;
                res *= stack.pop();
                res += stack.pop();
            }
            if (c == '+' || c == '-' || i == s.length() - 1) {
                res += sign * num;
                if (c == '+') {
                    sign = 1;
                } else if (c == '-') {
                    sign = -1;
                }
                num = 0;
            }

        }
        return res;
    }
}
