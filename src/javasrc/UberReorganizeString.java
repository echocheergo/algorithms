package javasrc;

import java.util.*;

public class UberReorganizeString {
    // sort using pq; add to sb, back to queue to hold then check if goes back to pq
        public  String reorganizeString(String S) {
//        if(S ==null||S.length()==0)
//
//        {
//            return "";
//        }
//
//        Map<Character, Integer> map = new HashMap<>();
//            for(
//        char c :S.toCharArray())
//
//        {
//            map.put(c, map.getOrDefault(c, 0) + 1);
//        }
//
//        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
//            pq.addAll(map.entrySet());
//        StringBuilder sb = new StringBuilder();
//        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
//            while(!pq.isEmpty())
//
//        {
//            Map.Entry<Character, Integer> entry = pq.poll();
//            sb.append(entry.getKey());
//            entry.setValue(entry.getValue() - 1);
//            queue.offer(entry);
//            while (queue.size() > 1) {
//                Map.Entry<Character, Integer> temp = queue.poll();
//                if (temp.getValue() > 0) {
//                    pq.offer(temp);
//                }
//            }
//        }
//            return sb.length()==S.length()?sb.toString():"";
//    }
    // count each char, 1) maxChar <= ori - maxChar - 1 2) fill new char[] even first then odd
    char[] ori = S.toCharArray();
    int[] count = new int[26];
    int max = 0;
    int maxPos = 0;
    // the kind of letters in the string
    int charNums = 0;

		for (int index = 0; index < S.length(); index ++) {

        int charVal = ori[index] - 'a';
        if (count[charVal] == 0) charNums ++;
        count[charVal] += 1;
        if (count[charVal] > max) {
            max = count[charVal];
            maxPos = charVal;
        }
    }

		if (max - (ori.length - max) > 1) {
        return "";
    }

    char[] newStr = new char[ori.length];

    // odd position
    stringMaker(newStr, count, charNums, maxPos, 0);

    // even pos
    stringMaker(newStr, count, charNums, maxPos, 1);

		return String.valueOf(newStr);
}

    public static void stringMaker(char[] newStr, int[] count, int charNums, int maxPos, int startPos) {
        int pos = startPos;
        int i = maxPos;

        for (; charNums > 0 && pos < newStr.length; i = (i + 1) % count.length) {
            while (count[i] != 0 && pos < newStr.length) {
                newStr[pos] = (char)('a' + i);
                count[i] --;
                if (count[i] == 0) charNums --;
                pos += 2;
            }
        }
    }
}
