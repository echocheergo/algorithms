package javasrc;

public class UberMinimunWindowSubstring {
    public String minWindow(String str, String t) {
        // substring satisfying some condition: hashmap + count(for condition) + two pointers
        // initilize map, move end and modify count
        // when hit condition: move start to make substring valid(max)/invalid(min) again
        // update global in while or outside (depends on whether min/max)
        int[] map = new int[256];
        for(char c: t.toCharArray()){
            map[c - 'A']++;
        }

        int minLen = Integer.MAX_VALUE, minStart = 0;

        int n = t.length();
        char[] sc = str.toCharArray();
        int s = 0, e = 0;
        while(e < sc.length){
            int ie = sc[e] - 'A';
            map[ie]--;
            if(map[ie] >= 0){
                n--;
            }

            if(n == 0){
                int is = sc[s] - 'A';
                while(map[is] < 0){
                    map[is]++;
                    s++;
                    is = sc[s] - 'A';
                }

                int len = e - s + 1;
                if(len < minLen){
                    minLen = len;
                    minStart = s;
                }

                map[is]++;
                s++;
                n++;
            }
            e++;
        }

        return minLen == Integer.MAX_VALUE ? "" : str.substring(minStart, minStart + minLen);
    }
}
