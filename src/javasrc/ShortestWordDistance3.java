package javasrc;

public class ShortestWordDistance3 {
    public int ShortestWordDistance3(String[] words, String w1, String w2) {
        // two pointers each for one word ind, init = -1
        // global min
        boolean same = w1.equals(w2);
        int i = -1, j = -1;

        int min = Integer.MAX_VALUE;

        for (int k = 0; k < words.length; k++){
            String curr = words[k];

            if (same){
                if (curr.equals(w1)){
                    i = j;
                    j = k;

                    min = (i < 0) ? min : Math.min(min,  j - i );
                }
            }else {
                if (curr.equals(w1)){
                    i = k;
                    min = (i < 0 || j < 0) ? min: Math.min(min, i - j);
                }else if (curr.equals(w2)){
                    j = k;
                    min = (i < 0 || j < 0) ? min: Math.min(min, j - i);
                }
            }
        }

        return min;

    }
}
