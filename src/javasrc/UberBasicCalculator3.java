package javasrc;
import java.util.ArrayDeque;
import java.util.Deque;

public class UberBasicCalculator3 {
    public int calculate(String s) {
        int l1 = 0, o1 = 1;
        int l2 = 1, o2 = 1;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(++i) - '0';
                }
                l2 = o2 == 1 ? l2 * num : l2 / num;
            } else if (c == '(') {
                stack.push(l1);
                stack.push(o1);
                stack.push(l2);
                stack.push(o2);
                l1 = 0; o1 = 1;
                l2 = 1; o2 = 1;

            } else if (c == ')') {
                int num = l1 + o1*l2;
                o2 = stack.poll(); l2 = stack.poll();
                o1 = stack.poll(); l1 = stack.poll();
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
}
