package oa;

public class GoogleOA2 {
    // linear scan plus two pointers to present the boarder of basket
    // number of fruits in basket is represented by the length between two pointers (included)
    // each can elongate till meet element different from itself
    // when both stopped (hitting different element), must move smaller pointer to the conflicting ele
    // update len for the last round as distance between conflicting ele and smaller pointer
    // keep global max
    public int GoogleOA2(int[] in) {
        int left1 = -1;
        int left2 = -1;
        int len = 0;
        int max = 0;
        for (int i = 0; i < in.length; i++) {
            if (left1 == -1 || in[i] == in[left1]) {
                left1 = i;
                len++;
                max = Math.max(max, len);
            } else if (left2 == -1 || in[i] == in[left2]) {
                left2 = i;
                len++;
                max = Math.max(max, len);
            } else {
                if (left1 < left2) {
                    len = i - left1;
                    left1 = i;
                } else {
                    len = i - left2;
                    left2 = i;
                }
            }
        }
        return max;
    }
}
