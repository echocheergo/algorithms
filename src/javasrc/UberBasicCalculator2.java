package javasrc;
import java.util.LinkedList;
public class UberBasicCalculator2 {
    public int calculate2(String s) {
        int l1 = 0, o1 = 1;
        int l2 = 1, o2 = 1;
            for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(++i) - '0';
                }
                l2 = o2 == 1 ? l2 * num : l2 / num;
            } else if (c == '*' || c == '/') {
                o2 = c == '*' ? 1 : -1;
            } else if (c == '+' || c == '-') {
                l1 = l1 + o1 * l2;
                o1 = c == '+' ? 1 : -1;
                l2 = 1;
                o2 = 1;
            }
        }
            return l1 + o1*l2;
    }
    public int calculate(String s) {
        // idea: let num ahead of sign, so fake a leading num and sigh
        // calculate when get to next sign
        // stack store numbers to add (positive, negative, or after */ )since need pop out for */
        if(s == null || s.length() == 0) {
            return 0;
        }
        char sign = '+';
        int num = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character. isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length() - 1) {
                if (sign =='+') {
                    stack.push(num);
                }
                if (sign == '-') {
                    stack.push(-num);
                }
                if (sign == '*') {
                    stack.push(stack.pop() * num);
                }
                if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }
        int res = 0;
        for (int i : stack) {
            res += i;
        }
        return res;
    }
}
