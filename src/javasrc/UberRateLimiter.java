package javasrc;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class UberRateLimiter {
    public static HashMap<Integer, Queue<Timestamp>> map = new HashMap<>();

    public  boolean isAllow(Integer clientID) {
        Timestamp time = new Timestamp(System.currentTimeMillis());
        System.out.println(map);
//  1.
        if(map == null || !map.containsKey(clientID)) {
            Queue<Timestamp> queue = new LinkedList<>();
            queue.add(time);
            map.put(clientID, queue);
            return true;
        } else {

            Timestamp time2 = new Timestamp(time.getTime() - 1000L);
            // time2 = time - timeLimit
            // iterate queue
            Queue<Timestamp> queue = map.get(clientID);
            Iterator iter = queue.iterator();
            while (iter.hasNext()) {
                Timestamp cur = (Timestamp) iter.next();
                if (cur.getTime() < time2.getTime()) {
                    iter.remove();
                }
            }
            if (queue.size() > 100) {
                return false;
            } else {
                queue.add(time);
                return true;
            }
        }


    }
}
