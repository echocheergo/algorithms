package javasrc;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class UberExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        // lianliankan stack
        // use a new class to parse log
        // for each end: get its own time, subtract that from func calling it
        Deque<Log> stack = new ArrayDeque<>();
        int[] res = new int[n];
        for (String s : logs) {
            Log log = new Log(s);
            if (log.isStart) {
                stack.push(log);
            } else {
                Log start = stack.pop();
                int t = log.time - start.time + 1;
                res[start.id] += t;
                if (!stack.isEmpty()) {
                    res[stack.peek().id] -= t;
                }

            }
        }
        return res;
    }
    class Log{
        int id;
        boolean isStart;
        int time;
        Log(String s) {
            String[] info = s.split(":");
            id = Integer.parseInt(info[0]);
            isStart = info[1].equals("start");
            time = Integer.parseInt(info[2]);
        }
    }
}
