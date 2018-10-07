package javasrc;

import java.util.HashMap;
import java.util.Map;
// corner case: 0, sign, overflow so use long (need to cast before use)
// hashmap to record cur digit and length (as index)
// boolean ^
// for map can cast long back to int to save space
public class UberFractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        // num is 0
        if (numerator == 0) {
            return "0";
        }
        // handle sign
        StringBuilder sb = new StringBuilder();
        sb.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        // get abs
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        // integer part
        sb.append(num / den);
        num %= den;
        if (num == 0) {
            return sb.toString();
        }
        // decimal
        sb.append(".");
        // hashmap to record decimal digit and index in sb
        Map<Integer, Integer> map = new HashMap<>();
        map.put((int) num, sb.length());
        while (num != 0) {
            num *= 10;
            sb.append(num / den);
            num %= den;
            // check if repeat
            if (map.containsKey((int) num)) {
                int ind = map.get((int) num);
                sb.insert(ind, "(");
                sb.append(")");
                return sb.toString();
            }
            map.put((int) num, sb.length());

        }
        return sb.toString();
    }
}
